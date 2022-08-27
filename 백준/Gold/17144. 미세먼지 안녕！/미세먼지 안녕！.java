import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	private static final int[] dr = { 0, 1, 0, -1 };
	private static final int[] dc = { 1, 0, -1, 0 };

	private static final int CLEANER = -1;

	private static int R;
	private static int C;
	private static Queue<Dust> queue;  // 미세먼지 BFS를 위한 큐
	private static int[][] room;
	private static int[][] copy;  // 미세먼지 확산 후 순환 전 상태의 방을 저장

	private static class Dust {
		public int r;  // 행
		public int c;  // 열
		public int amount;  // 미세먼지의 양

		public Dust(int r, int c, int amount) {
			super();
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		int T = Integer.parseInt(split[2]);

		queue = new ArrayDeque<>();  // 미세먼지 BFS를 위한 큐

		room = new int[R][C];
		int cleanerCCW = -1;  // 반시계 순환 공기청정기 행 인덱스
		int cleanerCW = -1;  // 시계 순환 공기청정기 행 인덱스
		for (int i = 0; i < R; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(split[j]);
				if (room[i][j] > 4) {  // 확산될 수 있는 먼지일 경우 (5이상일 경우만 확산 가능)
					queue.offer(new Dust(i, j, room[i][j]));  // 확산할 미세먼지를 큐에 등록
				}
				else if (room[i][j] == CLEANER) {  // 공기청정기일 경우
					// 최종적으로 저장되는 좌표는 시계방향 순환 공기청정기의 행 인덱스
					cleanerCW = i;
				}
			}
		}

		cleanerCCW = cleanerCW - 1;

		while (T > 0) {

			bfsDust();  // 1. 미세먼지가 확산된다.
			saveAfterDust();  // 확산 직후의 방 상태 저장

			// 아래 두 배열의 요소들은 dr, dc 배열을 접근하는 인덱스
			int[] ccw = { 0, 3, 2, 1 };  // 우, 상, 좌, 하 (반시계)
			int[] cw = { 0, 1, 2, 3 };  // 우, 하, 좌, 상 (시계)

			clean(cleanerCCW, 0, ccw);  // 2. 공기청정기가 작동한다. (반시계 방향)
			clean(cleanerCW, 0, cw);  // 2. 공기청정기가 작동한다. (시계 방향)
			afterClean();  // 3. 공기 청정 후 미세먼지들을 큐에 등록한다. (1초 뒤 1번이 실행되면서 확산)

			T--;
		}


		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 0) {
					sum += room[i][j];
				}
			}
		}

		System.out.println(sum);
	}

	private static void bfsDust() {

		// 큐 크기 확인 (동일 너비 대상 개수)
		int size = queue.size();

		while (--size >= 0) {
			// 현재 정점 꺼내기
			Dust dust = queue.poll();
			int amount = dust.amount / 5;  // 확산되는 양
			int cnt = 0;  // 확산된 방향의 개수

			// 4방향 확산
			for (int i = 0; i < 4; i++) {
				int testR = dust.r + dr[i];
				int testC = dust.c + dc[i];

				// 경계 체크
				if ((0 <= testR && testR < R) && (0 <= testC && testC < C)) {

					// 공기청정기가 아니면
					if (room[testR][testC] != CLEANER) {
						cnt++;  // 확산된 방향의 개수 증가
						room[testR][testC] += amount;  // 해당 칸으로 미세먼지 확산하고 누적
					}
				}
			}

			// 확산 후 남은 미세먼지의 양 계산
			room[dust.r][dust.c] -= amount * cnt;
		}
	}

	private static void saveAfterDust() {
		copy = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copy[i][j] = room[i][j];
			}
		}
	}

	// r, c: 공기청정기의 좌표
	// d: 공기청정기 순환을 위한 델타 배열
	// (백준 16926, 16935, 17406 문제 리뷰하기)
	private static void clean(int r, int c, int[] d) {

		int x = r;
		int y = c + 1;

		room[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			while (true) {
				int testR = x + dr[d[i]];
				int testC = y + dc[d[i]];

				if (!(0 <= testR && testR < R && 0 <= testC && testC < C)) {
					break;
				}

				if (testR == r && testC == c) {
					break;
				}

				room[testR][testC] = copy[x][y];
				x = testR;
				y = testC;
			}
		}
	}

	private static void afterClean() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] > 4) {  // 확산될 수 있는 먼지일 경우 (5이상일 경우만 확산 가능)
					queue.offer(new Dust(i, j, room[i][j]));  // 확산할 미세먼지를 큐에 등록
				}
			}
		}
	}
}