import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int L, C;
	private static char[] alphabet, code;
	private static StringBuilder sb;
    
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		L = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		code = new char[L];

		split = in.readLine().split(" ");
		alphabet = new char[C];
		for (int i = 0; i < C; i++) {
			alphabet[i] = split[i].charAt(0);
		}
		Arrays.sort(alphabet);

		// C 개 중 L개를 선택
		comb(0, 0, 0);

		System.out.println(sb);
	}
	private static void comb(int cnt, int start, int vowelCnt) {
		// 기저부분
		if( cnt == L) {
			if(vowelCnt >= 1 && (L-vowelCnt) >= 2) {
				sb.append(String.valueOf(code)).append("\n");
			}
			return;
		}
		// 유도부분
		for(int i = start; i < C; i++) {
			code[cnt] = alphabet[i];
			char c = code[cnt];
			if(c == 'a'||c == 'e'||c == 'i'|| c == 'o'||c== 'u') {
				comb(cnt+1, i+1, vowelCnt + 1);
			}else {
				comb(cnt+1, i+1, vowelCnt);
			}
		}
	}
}
