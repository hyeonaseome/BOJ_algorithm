import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 시험 본 과목의 개
		int N = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");

		int[] scores = new int[N];
		int max = 0;
		double sum = 0.0;

		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(split[i]);
			sum += scores[i];
			if (scores[i] > max)
				max = scores[i];
		}

		double answer = sum * 100 / (max * N);

		System.out.println(answer);
	}
}