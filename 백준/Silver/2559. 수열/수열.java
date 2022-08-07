import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		int max = 0;
		
		int[] map = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for (int i = 0; i < K; i++) {
			max += map[i];
		}

		int sum = max;
		for (int i = K; i < N; i++) {
			sum = sum - map[i - K] + map[i];
			if (sum > max) {
				max = sum;
			}
		}

		sb.append(max);

		System.out.println(sb);
	}
}
