import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = in.readLine();
		
		if (str.equals("1 2 3 4 5 6 7 8")) {
			sb.append("ascending");
		} else if (str.equals("8 7 6 5 4 3 2 1")) {
			sb.append("descending");
		} else {
			sb.append("mixed");
		}

		System.out.println(sb);

	}
}