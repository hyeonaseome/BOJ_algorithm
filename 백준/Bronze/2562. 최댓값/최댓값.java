import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int maxNum = 0;
		int maxIdx = 0;
		
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(in.readLine());
			if (num > maxNum) {
				maxNum = num;
				maxIdx = i + 1;
			}
		}
		sb.append(maxNum).append("\n").append(maxIdx);
		System.out.println(sb);
	}
}