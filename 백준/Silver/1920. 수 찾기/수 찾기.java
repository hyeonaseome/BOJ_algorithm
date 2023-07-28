import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");

		Set<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(split[i]);
		}

		int M = Integer.parseInt(in.readLine());
		split = in.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int answer = set.contains(split[i]) ? 1 : 0;
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}