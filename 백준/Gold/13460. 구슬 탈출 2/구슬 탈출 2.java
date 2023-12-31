import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 구슬 탈출은 
 * 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 
 * 빨간 구슬을 구멍을 통해 빼내는 게임
 * 
 * 보드의 세로 크기는 N, 가로 크기는 M
 * 
 * 네 가지 동작이 가능: 상, 하, 좌, 우
 * 
 * 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 출력
 * 
 * BFS 활용하기
 */
public class Main {

	private static char SPACE = '.'; // '.'은 빈 칸을 의미하고,
	private static char BLOCK = '#';// '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며,
	private static char HOLE = 'O';// 'O'는 구멍의 위치를 의미한다.
	private static char RED = 'R';// 'R'은 빨간 구슬의 위치,
	private static char BLUE = 'B';// 'B'는 파란 구슬의 위치

	private static Point marble;

	private static char[][] map;

	private static class Point {
		int redX;
		int redY;
		int blueX;
		int blueY;
		int dir;

		public Point() {
		};

		public Point(int redX, int redY, int blueX, int blueY) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
		}

		@Override
		public String toString() {
			return "[redX=" + redX + ", redY=" + redY + ", blueX=" + blueX + ", blueY=" + blueY + "]";
		}

	}

	// 구멍의 개수는 한 개 이며, 빨간 구슬과 파란 구슬은 항상 1개가 주어진다.
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 3 ≤ N, M ≤ 10
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		map = new char[N][M];
		marble = new Point();

		for (int i = 0; i < N; i++) {
			String readLine = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = readLine.charAt(j);

				// 빨간 구슬, 파란 구슬 위치 찾기
				if (map[i][j] == RED) {
					marble.redX = i;
					marble.redY = j;
					map[i][j] = SPACE;
				}
				if (map[i][j] == BLUE) {
					marble.blueX = i;
					marble.blueY = j;
					map[i][j] = SPACE;
				}
			}
		}

		// 최소 몇 번 만에 빨간 구슬 빼내는지..
		sb.append(bfs(N, M));

		System.out.println(sb);
	}

	// 상, 우, 좌, 하
	private static int[] dx = { -1, 0, 0, 1 };
	private static int[] dy = { 0, 1, -1, 0 };

	private static int bfs(int N, int M) {

		Queue<Point> queue = new ArrayDeque<>();
		marble.dir = -1;
		queue.offer(marble);

		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			depth++;
			if (depth > 11)
				return -1;

			while (--size >= 0) {
				Point cur = queue.poll();

				// 기저 조건 : 빨간 구슬이 구멍에 빠지면 성공
				if (map[cur.redX][cur.redY] == HOLE) {
					return depth - 1;
				}

				// 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때까지
				for (int i = 0; i < 4; i++) {
					if (cur.dir + i == 3) continue;
					Point nextPoint = moveMarble(cur, i);
					// System.out.println("next: " + nextPoint);

					if (nextPoint == null) continue;
					if (cur.toString().equals(nextPoint.toString())) continue;
					nextPoint.dir = i;
					queue.offer(nextPoint);

				}
			}
		}

		return -1;
	}

	private static Point moveMarble(Point cur, int dir) {
		// System.out.println("moveMarble: " + cur);
		Point newCur = new Point();
		int testRedX = cur.redX + dx[dir];
		int testRedY = cur.redY + dy[dir];
		int testBlueX = cur.blueX + dx[dir];
		int testBlueY = cur.blueY + dy[dir];

		// 가지 치기
		if (map[testBlueX][testBlueY] == HOLE)
			return null; // 파란구슬이 구멍에 빠짐

		// 기저 조건 : 가는 방향의 다음이 막혀있다면 움직임을 멈춤
		if (map[testRedX][testRedY] != SPACE && map[testBlueX][testBlueY] != SPACE) {
			newCur.blueX = cur.blueX;
			newCur.blueY = cur.blueY;
			if (map[testRedX][testRedY] == HOLE) {
				newCur.redX = testRedX;
				newCur.redY = testRedY;
				return newCur;
			}
			newCur.redX = cur.redX;
			newCur.redY = cur.redY;
			return newCur;
		}

		// 빨간 공만 멈출 때
		if (map[testRedX][testRedY] != SPACE && map[testBlueX][testBlueY] == SPACE) {
			newCur.redX = cur.redX;
			newCur.redY = cur.redY;

			newCur.blueX = testBlueX;
			newCur.blueY = testBlueY;

			// 기저조건: 파란 공 다음이 빨간 공일때 (현 방향으로 이동 멈춤)
			if (testBlueX == cur.redX && testBlueY == cur.redY) {
				newCur.blueX = cur.blueX;
				newCur.blueY = cur.blueY;
				return newCur;
			}
			return moveMarble(newCur, dir);
		}
		// 파란 공만 멈출 때
		else if (map[testRedX][testRedY] == SPACE && map[testBlueX][testBlueY] != SPACE) {
			newCur.redX = testRedX;
			newCur.redY = testRedY;
			newCur.blueX = cur.blueX;
			newCur.blueY = cur.blueY;

			// 기저조건: 빨간 공 다음이 파란 공일때 (현 방향으로 이동 멈춤)
			if (testRedX == cur.blueX && testRedY == cur.blueY) {
				newCur.redX = cur.redX;
				newCur.redY = cur.redY;
				return newCur;
			}
			return moveMarble(newCur, dir);
		}

		// 둘다 이동
		newCur.redX = testRedX;
		newCur.redY = testRedY;
		newCur.blueX = testBlueX;
		newCur.blueY = testBlueY;
		return moveMarble(newCur, dir);
	}

}