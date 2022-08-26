import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// BOJ 4485 녹색 옷 입은 애가 젤다지?
// Dijkstra => D[][]를 이차원으로 풀기
public class Main {

	// 우, 하, 좌, 상
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};

	private static class Vertex implements Comparable<Vertex> {
		public int x;  // 정점 번호
		public int y;
		public int minD;  // 출발지에서 자신으로의 최소비용

		public Vertex(int x, int y, int minDistance) {
			this.x = x;
			this.y = y;
			this.minD = minDistance;
		}

		@Override
		public String toString() {
			return "Vertex [x=" + x + ", y=" + y + ", minD=" + minD + "]";
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minD - o.minD;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		int T = 0;
		while(true) {
			int N = Integer.parseInt(in.readLine());
			if (N == 0) {
				break;
			}
			sb.append("Problem "+ (++T)+": ");

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			/**
			 * 2. 알고리즘 풀기
			 */

			int startX = 0;   // 출발정점
			int startY = 0;
			int endX = N - 1;// 도착정점
			int endY = N - 1;


			// 다익스트라 알고리즘에 필요한 자료구조
			int[][] D = new int[N][N]; // 출발지에서 자신으로 오는데 소요되는 최소비용
			boolean[][] visited = new boolean[N][N]; // 처리한 정점 여부

			PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
			pQueue.offer(new Vertex(startX, startY, D[startX][startY]));

			for (int i = 0; i < N; i++) {
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}

			// 출발정점 처리
			D[startX][startY] =  map[0][0];

			while(!pQueue.isEmpty()) {

				// step1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
				// (방문해야하는 정점 중 출발지에서 가장 가까운 정점 찾기)
				Vertex cur = pQueue.poll();
				
				// 이미 처리된 정점이 큐에서 또 나오면 무시
				if (visited[cur.x][cur.y]) {
					continue;
				}

				// step2. 방문처리
				visited[cur.x][cur.y] = true;
				if(cur.x == endX && cur.y == endY) break; // 문제가 start -> end로의 최단이면 탈출

				// step3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신

				for (int l = 0; l < 4; l++) {
					int testX = cur.x + dx[l];
					int testY = cur.y + dy[l];
					if(!(0 <= testX && testX < N && 0 <= testY && testY < N) || visited[testX][testY] ) continue;
					
					if (D[testX][testY] > D[cur.x][cur.y] + map[testX][testY]) {						D[testX][testY] = D[cur.x][cur.y] + map[testX][testY];
						pQueue.offer(new Vertex(testX, testY, D[testX][testY]));
					}
				}


			}
			sb.append(D[endX][endY]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}