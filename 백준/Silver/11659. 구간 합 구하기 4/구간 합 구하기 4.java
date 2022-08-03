import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
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
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] sums = new int [nums.length + 1];
		for (int i = 1; i <= N; i++) {
			sums[i] = sums[i-1] + nums[i-1];
		}
		
		/**
		 * 2. 알고리즘 풀기
		 */
		int answer = 0;
		for (int i = 0 ; i < M; i++) {
			answer = 0;
			String[] newline = in.readLine().split(" ");
			int start = Integer.parseInt(newline[0]) ;
			int end = Integer.parseInt(newline[1]);
			answer = sums[end] - sums[start - 1];
			sb.append(answer+"\n");
		}
		
		

		System.out.println(sb);
	}

}
