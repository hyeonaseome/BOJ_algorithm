import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int count = 0;
		int quotientFIve = N / 5;

		for (int i = quotientFIve ; i >= 0 ; i--) {
			int num = N - 5*i;
			if (num% 3 == 0) {
				count = i + num/3;
				break;
			}
		}
		
		if (count <= 0 ) {
			count = -1;
		}

		sb.append(count);
		System.out.println(sb);
	}
}

