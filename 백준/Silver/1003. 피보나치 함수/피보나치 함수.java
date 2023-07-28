import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int[][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = 40;
		memo = new int[num + 1][3];
		for (int i = 0; i <= num; i++) {
			memo[i][0] = -1;
			memo[i][1] = -1;
		}
		fibonacci(num);

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			int n = Integer.parseInt(in.readLine());
			sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
		}

		System.out.println(sb);
	}

	private static void fibonacci(int n) {
		if (n == 0) {
			memo[0][0] = 1;
			memo[0][1] = 0;
			return;
		} else if (n == 1) {
			memo[1][0] = 0;
			memo[1][1] = 1;
			return;
		} else {
			if (memo[n][0] == -1) {
				fibonacci(n - 1);
				fibonacci(n - 2);
				memo[n][0] = memo[n - 1][0] + memo[n - 2][0];
				memo[n][1] = memo[n - 1][1] + memo[n - 2][1];
			}
			return;
		}
	}
}