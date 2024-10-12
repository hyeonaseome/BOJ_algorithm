import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());

		String[] words = new String[N];
		Set<String> set = new HashSet<>();

		int qIdx = -1;

		for (int i = 0; i < N; i++) {
			words[i] = in.readLine();
			set.add(words[i]);
			if (words[i].equals("?")) {
				qIdx = i;
			}
		}

		int M = Integer.parseInt(in.readLine());
		String answer = "";

		for (int i = 0; i < M; i++) {
			String str = in.readLine();
			if (set.contains(str))
				continue;

			if (qIdx == 0 || (str.charAt(0) == words[qIdx - 1].charAt(words[qIdx - 1].length() - 1))) {
				if (qIdx == words.length - 1 || (str.charAt(str.length() - 1) == words[qIdx + 1].charAt(0))) {
					answer = str;
				}
			}
		}

		System.out.println(answer);

	}
}
