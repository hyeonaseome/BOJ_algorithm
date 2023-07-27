import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		int min = 1_000_001;
		int max = -1_000_001;
		
		String[] split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(split[i]);
			if (n < min)
				min = n;
			if (n > max) {
				max = n;
			}
		}
		
		sb.append(min).append(" ").append(max);
		System.out.println(sb);
	}
}