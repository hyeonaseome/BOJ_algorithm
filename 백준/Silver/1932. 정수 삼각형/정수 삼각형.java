import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 삼각형의 크기
		int n = Integer.parseInt(in.readLine());

		int[][] triangle = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				triangle[i][j] = Integer.parseInt(split[j]);
				
				if (i < 1) continue;
				int left = j > 0 ? triangle[i - 1][j - 1] : 0;
				triangle[i][j] += Math.max(left, triangle[i - 1][j]);
			}
		}

		int answer = 0;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, triangle[n - 1][i]);
		}

		System.out.println(answer);
	}

}