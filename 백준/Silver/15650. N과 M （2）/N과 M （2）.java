import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N, M;
	static int[] numbers;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] split = in.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		numbers = new int[M];

		comb(0, 0);

		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {

		if (cnt == M) {
			for (int i = 0; i < numbers.length; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = i + 1;

			comb(cnt + 1, i + 1);

		}

	}
}