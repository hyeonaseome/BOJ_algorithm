import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] alphabets = new int[26];
		String str = in.readLine().toUpperCase();
		int maxUseCnt = 0;
		int maxUseIdx = -1;
		
		for (int i = 0; i< str.length(); i++) {
			int alphabetIdx = str.charAt(i) - 'A';
			alphabets[alphabetIdx] += 1;
			
			if (maxUseCnt < alphabets[alphabetIdx]) {
				maxUseCnt = alphabets[alphabetIdx];
				maxUseIdx = alphabetIdx;
			} else if (maxUseCnt == alphabets[alphabetIdx]) {
				maxUseIdx = -1;
			}
		}
		
		if (maxUseIdx == -1) {
			sb.append("?");
		} else{
			sb.append((char) (maxUseIdx + 65));
		}
		
		System.out.println(sb);
	}
}