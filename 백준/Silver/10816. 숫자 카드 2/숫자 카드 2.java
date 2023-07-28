import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(split[i], map.getOrDefault(split[i], 0) + 1);
		}

		int M = Integer.parseInt(in.readLine());
		split = in.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			sb.append(map.getOrDefault(split[i], 0)).append(" ");
		}

		System.out.println(sb);
	}
}