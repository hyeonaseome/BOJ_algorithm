import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int M, N, K;
	private static int[][] board;
	
	// 상, 우, 좌, 하 
	private static int[] dx = {-1, 0, 0, 1};
	private static int[] dy = {0, 1, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String[] split = in.readLine().split(" ");
			M = Integer.parseInt(split[0]);
			N = Integer.parseInt(split[1]);
			K = Integer.parseInt(split[2]);
			
			board = new int[N][M];
			int[][] xyList = new int[K][2];
			
			for (int k = 0; k  < K; k++) {
				split = in.readLine().split(" ");
				int y = Integer.parseInt(split[0]);
				int x = Integer.parseInt(split[1]); 
				board[x][y] = -1;
				xyList[k][0] = x;
				xyList[k][1] = y;
			}
			
			int cnt = 0;
			for (int k = 0; k  < K; k++) {
				int x = xyList[k][0];
				int y = xyList[k][1];
				if (board[x][y] == -1) {
					cnt++;
					dfs(x, y, cnt);
				}
			}

			sb.append(cnt).append("\n");
			
		}
		

		System.out.println(sb);
	}
	
	private static void dfs(int x, int y, int cnt) {
		board[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int testX = x + dx[i];
			int testY = y + dy[i];
			
			if (0 <= testX && testX< N && 0 <= testY && testY < M) {
				if (board[testX][testY] == -1) {
					dfs(testX, testY, cnt);
				}
			}
		}
	}

}