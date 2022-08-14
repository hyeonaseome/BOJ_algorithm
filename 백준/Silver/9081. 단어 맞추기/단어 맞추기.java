import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <=T; t++) {
			st = new StringTokenizer(in.readLine());
			char[] word = st.nextToken().toCharArray();
			
			np(word);
			System.out.println(String.valueOf(word));
		}
	}

	private static boolean np(char[] word) {
		int N = word.length;
		int i = N - 1;
		while ( i > 0 && word[i - 1] >= word[i]) i--;
		if (i == 0)  return false;
		int j = N - 1;
		while ( word[i - 1] >= word[j])  j--;
		
		swap(i-1, j, word);
		int k = N -1 ;
		while(i < k) swap(i++, k--, word);
		return true;
	}

	private static void swap(int i, int j, char[] word) {
		char temp = word[i];
		word[i] = word[j];
		word[j] = temp;
	}
}
