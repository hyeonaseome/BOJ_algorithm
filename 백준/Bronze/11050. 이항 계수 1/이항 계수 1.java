import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);

		int[][] comb = new int[11][11];

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == 0) {
					comb[i][j] = 1;
				} else {
					comb[i][j] = comb[i - 1][j] + comb[i - 1][j - 1];
				}
			}
		}

		System.out.println(comb[N][K]);
	}
}