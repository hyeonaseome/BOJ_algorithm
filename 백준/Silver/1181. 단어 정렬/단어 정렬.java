import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine()); // 단어의 개수
		
		Set<String> wordSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			wordSet.add(in.readLine());
		}

		String[] words = wordSet.toArray(new String[0]);
		Arrays.sort(words, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// 1. 길이가 짧은 것 부터
				if (s1.length() != s2.length()) {
					return s1.length() - s2.length();
				}

				// 2. 길이가 같으면 사전 순으로
				return s1.compareTo(s2);
			}
		});

		for (int i = 0; i < words.length; i++) {
			sb.append(words[i]).append("\n");
		}

		System.out.println(sb);
	}
}