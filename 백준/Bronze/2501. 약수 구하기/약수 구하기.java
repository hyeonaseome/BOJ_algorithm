import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		
		int answer = 0;
		
		for (int i = 1, cnt = 0; i <= N; i++) {
			if (N % i == 0) {
				if (++cnt == K) {
					answer = i;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}