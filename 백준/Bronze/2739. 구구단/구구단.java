import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(in.readLine());
		
		for (int i = 1; i <= 9; i++) {
			sb.append(N+" * "+i).append(" = ").append(N *i).append("\n");
		}
		
		System.out.println(sb);
	}
}