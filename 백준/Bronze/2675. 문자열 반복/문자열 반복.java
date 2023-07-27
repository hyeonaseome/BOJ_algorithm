import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// T: 테스트 케이스의 개수
		int T = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= T; i++) {
			String[] split = in.readLine().split(" ");
			int R = Integer.parseInt(split[0]);
			for (int j = 0 ; j < split[1].length(); j++) {
				for (int r = 0; r < R; r++) {
					sb.append(split[1].charAt(j));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}