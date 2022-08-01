import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			/**
    		 * 2. 알고리즘 풀기
    		 */
			String[] str = in.readLine().split("");

			String now = "0";
			int result = 0;
			
			for (int i = 0; i < str.length; i++) {
				if(!str[i].equals(now)) {
						result +=1;
						now = str[i];
				}
			}

			/**
    		 * 3. 정답 출력
    		 */
			sb.append(result + "\n");
		}

		System.out.println(sb);
		
		System.out.printf("%.1f", (double) 7/2);
	}
}
