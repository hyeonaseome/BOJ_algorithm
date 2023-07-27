import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] alphabets = new int[26];
		
		String str = in.readLine().toUpperCase();
		
		boolean IsMulti = false;
		int maxUseCnt = 0;
		char maxUseChar = 'a';
		
		for (int i = 0; i< str.length(); i++) {
			int alphabetIdx = str.charAt(i) - 'A';
			alphabets[alphabetIdx] += 1;
			
			if (maxUseCnt < alphabets[alphabetIdx]) {
				maxUseCnt = alphabets[alphabetIdx];
				maxUseChar = str.charAt(i);
				IsMulti = false;
			} else if (maxUseCnt == alphabets[alphabetIdx]) {
				IsMulti = true;
			}
		}
		
		if (IsMulti) {
			sb.append("?");
		} else{
			sb.append(maxUseChar);
		}
		
		System.out.println(sb);
	}
}
