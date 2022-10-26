import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		
		for (int t = 0; t < T; t++) {
			// 다섯개의 정수
			String[] split = in.readLine().split(" ");
			
			int[] scores = new int[5];
			for (int i = 0; i < 5; i++) {
				scores[i] = Integer.parseInt(split[i]);
			}
			
			// 점수 순서대로
			Arrays.sort(scores);
			
			if(scores[3] - scores[1] >= 4) {
				sb.append("KIN");
			}else {
				sb.append(scores[1] + scores[2]+ scores[3]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}
}