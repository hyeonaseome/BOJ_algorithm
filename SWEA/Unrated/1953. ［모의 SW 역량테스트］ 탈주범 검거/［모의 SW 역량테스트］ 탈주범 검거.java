import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


class Solution
{
	private static int N, M, R, C, L, answer;
	private static int[][] map;
	// 우, 하, 좌, 상
	private static final int[] dr = {0, 1, 0, -1};
	private static final int[] dc = {1, 0, -1, 0};
	
	private static class loc {
		public int x;
		public int y;
		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			sb.append("#"+test_case+" ");
			StringTokenizer st = new StringTokenizer(in.readLine());
			//지하 터널 지도의 세로 크기 N, 가로 크기 M
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//맨홀 뚜껑 장소의 세로 위치 R, 가로 위치 C
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			// 탈출 후 소요된 시간 L
			L = Integer.parseInt(st.nextToken());
			answer = 0;
			
			// 지하 터널 지도 정보
			// 숫자 1 ~ 7은 해당 위치의 터널 구조물 타입을 의미하,
			// 숫자 0 은 터널이 없는 장소를 의미
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			// 탈주범이 위치할 수 있는 장소의 개수 출력
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void bfs() {
		Queue<loc> que = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];
		
		int t = 0;
		que.offer(new loc(R, C));
		isVisited[R][C] = true;
		while(!que.isEmpty()) {
			if (t == L) {
				break;
			}
			int size = que.size();
			answer += size;
			while(--size >= 0) {
				loc cur = que.poll();
				int curX = cur.x;
				int curY = cur.y;
				
				int type = map[curX][curY];
				// 우, 하, 좌, 상
				// 0,  1,  2,  3
				int[] dir = {0};
				switch(type) {
				case 1:
					dir = new int []{0, 1, 2, 3};
					break;
				case 2:
					dir = new int []{1, 3};
					break;
				case 3:
					dir = new int []{0, 2};
					break;
				case 4:
					dir = new int []{0, 3};
					break;
				case 5:
					dir = new int []{0, 1};
					break;
				case 6:
					dir = new int []{1, 2};
					break;
				case 7:
					dir = new int []{2, 3};
					break;
				}
				
				for (int k : dir) {
					int testX = curX + dr[k];
					int testY = curY + dc[k];
					if (0 <= testX && testX < N && 0 <= testY && testY < M 
							&& !isVisited[testX][testY] && map[testX][testY] != 0) {
						int testtype = map[testX][testY];
						switch(k) {
						case 0: // 좌 연결 (1, 3, 6, 7)
							if (!(testtype == 1 || testtype == 3||testtype == 6||testtype == 7)) continue;
							break;
						case 1: // 상 연결 (1, 2, 4, 7)
							if (!(testtype == 1|| testtype == 2||testtype == 4|testtype == 7)) continue;
							break;
						case 2: // 우 연결 (1, 3, 4, 5)
							if (!(testtype == 1|| testtype == 3||testtype == 4|testtype == 5)) continue;
							break;
						case 3: // 하 연결 (1, 2, 5, 6)
							if (!(testtype == 1|| testtype == 2||testtype == 5|testtype == 6)) continue;
							break;
						
						}
						isVisited[testX][testY] = true;
						que.offer(new loc(testX, testY));
					}
				}
			}
			t++;
		}
		
		
	}
}