import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int N, M;
	private static int[] numbers;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);

		numbers = new int[M];
		
		perm(0);

		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (cnt != 0 && i < numbers[cnt - 1]) {
				continue;
			}
			numbers[cnt] = i;
			perm(cnt + 1);
			numbers[cnt] = 0;
		}
	}

}