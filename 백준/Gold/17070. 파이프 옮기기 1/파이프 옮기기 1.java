import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[][] map = new int [N + 1][N + 1];
		
		for (int i = 1; i<= N; i++) {
			map[i] = Arrays.stream(("0 "+ in.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// 1: 가로, 2: 세로, 3: 대각선
		int[][][] dir= new int [N + 1][N + 1][4];

		int[] dx = {0, 0, -1, -1};
		int[] dy = {0, -1, -1, 0};
		
		int x = 1;
		int y = 2;

		dir[x][y][1] = -1;
		
		for( int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				if (map[i][j] == 1) { continue; }
				for (int k = 1; k < 4; k++) {
					int testX = i + dx[k];
					int testY = j + dy[k];
					
					if ((0 < testX && testX <= N) &&
							(1 < testY && testY <= N) &&
							(map[testX][testY] != 1)) {
						
						switch(k) {
						case 1:
							dir[i][j][1] = dir[testX][testY][1] + dir[testX][testY][2] ;
							break;
						case 2:
							dir[i][j][2] = dir[testX][testY][1] + dir[testX][testY][2] + dir[testX][testY][3];
							if (map[i][j-1] == 1 || map[i - 1][j] == 1) {
								dir[i][j][2] = 0;
							}
							break;
						case 3:
							dir[i][j][3] = dir[testX][testY][2] + dir[testX][testY][3];
							break;
							
						}
					}
				}
			}
		}

		sb.append(-1* (dir[N][N][1] +dir[N][N][2] +dir[N][N][3]));
		System.out.println(sb);
	}
}

