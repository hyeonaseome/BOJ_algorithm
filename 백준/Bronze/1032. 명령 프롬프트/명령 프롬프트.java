import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		String [] files = new String [N];
		for (int i = 0; i < N; i++) {
			files[i] = in.readLine();
		}

		int filenamelen = files[0].length();
		char[] pattern = new char [filenamelen];
		for (int i = 0; i < filenamelen; i++) {
			char check = files[0].charAt(i);
			boolean flag = true;
			for (int j = 1; j < N; j++) {
				if (check != files[j].charAt(i)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				pattern[i] = check;
			}else {
				pattern[i] = '?';
			}
		}

		sb.append(String.valueOf(pattern));
		System.out.println(sb);
	}
}
