import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] alpha = new char[26];
		char[] name = in.readLine().toCharArray();
		for (int i = 0; i < name.length; i++) {
			alpha[name[i] - 'A'] += 1;
		}

		int oddCnt = 0;
		int oddIndex = -1;
		for (int i = 0; i < 26; i++) {
			if(alpha[i] % 2 == 1) {
				oddCnt++;
				oddIndex = i;
			}
		}

		int namelen = name.length;
		char[] newname = new char[namelen];
		if(oddCnt > 1) {
			sb.append("I'm Sorry Hansoo");
		}

		else if (oddCnt == 0) {
			int index = 0;
			for (int i = 0; i <26; i++) {
				int alphacnt = alpha[i];
				if(alphacnt > 0) {
					for(int j = index; j < index + alphacnt/ 2 ; j++) {
						newname[j] = (char)('A' + i);
						newname[namelen - j - 1] = (char)('A' + i);
					}
					index = index + alphacnt/ 2;
				}
			}
			sb.append(String.valueOf(newname));
		}else if (oddCnt == 1) {
			newname[namelen/2] =(char)('A' + oddIndex);
			alpha[oddIndex] -= 1;

			int index = 0;
			for (int i = 0; i <26; i++) {
				int alphacnt = alpha[i];
				if(alphacnt > 0) {
					for(int j = index; j < index + alphacnt/ 2 ; j++) {
						newname[j] = (char)('A' + i);
						newname[namelen - j - 1] = (char)('A' + i);
					}
					index = index + alphacnt/ 2;
				}
			}
			sb.append(String.valueOf(newname));
		}

		System.out.println(sb);
	}
}
