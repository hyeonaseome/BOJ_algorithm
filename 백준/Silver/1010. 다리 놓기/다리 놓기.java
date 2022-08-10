import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			String[] split = in.readLine().split(" ");
			int N = Integer.parseInt(split[0]);
			int M = Integer.parseInt(split[1]);		
			
			long[][] com = new long [31][31];
			
			for (int i = 1; i < M + 1; i++) {
				for (int j = 0; j <= N; j++) {
					if (j == 0 || j == i) {
						com[i][j] = 1L;
					}else {
						com[i][j] = com[i-1][j-1] + com[i-1][j];
					}
				}
			}

			/**
			 * 2. 알고리즘 풀기
			 */
			
			long answer = com[M][N];

			/**
			 * 3. 정답 출력
			 */
			sb.append(answer+ "\n");

		}

		System.out.println(sb);
	}
}
