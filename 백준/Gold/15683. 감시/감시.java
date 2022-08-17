import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private static int N, M, min, startX, startY;
	private static int[][] map, copymap;
	private static ArrayList<CCTV> cctvs;
	private static int[] numbers;

	// 상, 우, 하, 좌
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	// cctv 번호에 따른 경우의 수
	private static int[] cases = {0, 4, 2, 4, 4, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		min = Integer.MAX_VALUE;

		cctvs = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j< M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvs.add(new CCTV(map[i][j], i, j));
				}
			}
		}
		numbers = new int[cctvs.size()];

		// 1: 상, 우, 하, 좌
		// 2: 상하, 좌우
		// 3: 상우, 우하, 하좌, 좌상
		// 4: 좌상우, 상우하, 우하좌, 하좌상
		// 5: 상우좌하		

		/**
		 * 2. 알고리즘 풀기
		 */
		perm(0);
		/**
		 * 3. 정답 출력
		 */
		sb.append(min);

		System.out.println(sb);
	}

	private static void perm(int cnt) {
		// 기저 조건
		if (cnt == cctvs.size()) {			
			// map 복사
			copymap = new int[N][M];
			for (int i = 0; i< N; i++) {
				for (int j = 0; j< M; j++) {
					copymap[i][j] = map[i][j];
				}
			}

			for (int i = 0; i < cctvs.size(); i++) {
				// cctv 위치 (탐색 시작 위치)
				startX = cctvs.get(i).x;
				startY = cctvs.get(i).y;

				// cctv 번호에 따라 탐색 방향 결정
				int dir = numbers[i];
				CCTV cctv = cctvs.get(i);
				switch(cctv.no) {
				case 1:
					watch(cctv, dir);
					break;
				case 2:
					switch(dir) {
					case 0: // 상, 하
						watch(cctv, 0);
						watch(cctv, 2);
						break;
					case 1: // 우, 좌
						watch(cctv, 1);
						watch(cctv, 3);
						break;
					}
					break;
				case 3:
					switch(dir) {
					case 0: // 상, 우
						watch(cctv, 0);
						watch(cctv, 1);
						break;
					case 1: // 우, 하
						watch(cctv, 1);
						watch(cctv, 2);
						break;
					case 2: // 하, 좌
						watch(cctv, 2);
						watch(cctv, 3);
						break;
					case 3: // 좌, 상
						watch(cctv, 3);
						watch(cctv, 0);
						break;
					}
					break;
				case 4:
					switch(dir) {
					case 0: // 좌, 상, 우
						watch(cctv, 3);
						watch(cctv, 0);
						watch(cctv, 1);
						break;
					case 1: // 상, 우, 하
						watch(cctv, 0);
						watch(cctv, 1);
						watch(cctv, 2);
						break;
					case 2: // 우, 하, 좌
						watch(cctv, 1);
						watch(cctv, 2);
						watch(cctv, 3);
						break;
					case 3: // 하, 좌, 상
						watch(cctv, 2);
						watch(cctv, 3);
						watch(cctv, 0);
						break;
					}
					break;
				case 5: // 상, 우, 좌, 하
					for (int k = 0; k < 4;k++) {
						watch(cctv, k);
					}
					break;
				}
			}

			int count = 0;
			// 사각지대의 크기측정
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copymap[i][j] == 0) count++;
				}
			}

			// 최소값 변경
			if (min > count) {
				min = count;
			}
			return;
		}
		// 유도 부분
		int size = cases[cctvs.get(cnt).no];
		for (int i = 0; i < size ; i++) {
			numbers[cnt] = i;
			perm(cnt + 1);
		}
	}

	// BFS로 방향에 맞게 감시 
	public static void watch(CCTV cctv, int d) {
		Queue<CCTV> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		queue.add(cctv);
		visited[cctv.x][cctv.y] = true;

		while(!queue.isEmpty()) {
			int nx = queue.peek().x + dx[d];
			int ny = queue.poll().y + dy[d];

			// 범위를 벗어나거나 벽을 만나면 끝 
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || copymap[nx][ny] == 6) { 
				break;
			}

			if(copymap[nx][ny] == 0) { 
				copymap[nx][ny] = -1; // 빈칸이라면 감시할 수 있다는 의미로 -1 
				queue.add(new CCTV(cctv.no, nx, ny));
			} else { // 다른 cctv가 있거나 이미 감시된 칸이라면 
				queue.add(new CCTV(cctv.no, nx, ny)); // 그냥 통과 
			}
		}
	}

	private static boolean isValid(int x, int y) {
		return 0 <= x && x <N && 0 <= y && y <M ;
	}
}

class CCTV{
	int no;
	int x;
	int y;


	public CCTV(int no, int x, int y) {
		this.no = no;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "CCTV [no=" + no + ", x=" + x + ", y=" + y + "]";
	}
}