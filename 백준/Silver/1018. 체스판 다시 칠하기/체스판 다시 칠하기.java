import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int M = Integer.parseInt(split[0]);
		int N = Integer.parseInt(split[1]);

		int[][][] chessBoardWB = new int[M][N][2];

		for (int i = 0; i < M; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				char color = line.charAt(j);
				if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
					if (color == 'B')
						chessBoardWB[i][j][0] += 1;
					else
						chessBoardWB[i][j][1] += 1;
				} else {
					if (color == 'B')
						chessBoardWB[i][j][1] += 1;
					else
						chessBoardWB[i][j][0] += 1;
				}

				if (j > 0) {
					chessBoardWB[i][j][0] += chessBoardWB[i][j - 1][0];
					chessBoardWB[i][j][1] += chessBoardWB[i][j - 1][1];
				}
				if (i > 0) {
					chessBoardWB[i][j][0] += chessBoardWB[i - 1][j][0];
					chessBoardWB[i][j][1] += chessBoardWB[i - 1][j][1];
				}
				if (i > 0 && j > 0) {
					chessBoardWB[i][j][0] -= chessBoardWB[i - 1][j - 1][0];
					chessBoardWB[i][j][1] -= chessBoardWB[i - 1][j - 1][1];
				}
			}
		}
		
		int min = M * N + 1;
		
		for (int i = 7; i < M; i++) {
			for (int j = 7; j < N; j++) {
				
				int white = chessBoardWB[i][j][0];
				int black = chessBoardWB[i][j][1];
				if (j > 7) {
					white -= chessBoardWB[i][j - 8][0];
					black -= chessBoardWB[i][j - 8][1];
				}
				if (i > 7) {
					white -= chessBoardWB[i - 8][j][0];
					black -= chessBoardWB[i - 8][j][1];
				}
				
				if (i > 7 && j > 7) {
					white += chessBoardWB[i - 8][j - 8][0];
					black += chessBoardWB[i - 8][j - 8][1];
				}

				min = Math.min(white, min);
				min = Math.min(black, min);
			}
		}

		System.out.println(min);
	}
}