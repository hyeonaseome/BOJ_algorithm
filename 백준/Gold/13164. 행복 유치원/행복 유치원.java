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

		int[] child = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int [] diff = new int[N-1];

		for(int i = 1; i < N; i++) {
			diff[i - 1] = child[i] - child[i-1];
		}
		
		Arrays.sort(diff);

		int answer = 0;
		for (int i = 0; i< N-K; i++) {
			answer += diff[i];
		}

		sb.append(answer);
		System.out.println(sb);
	}

}