import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int N, M, max;
	static int[] snack;
	static int[] numbers = new int[2];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			String[] split = in.readLine().split(" ");
			N = Integer.parseInt(split[0]); // 과자 봉지 개수
			M = Integer.parseInt(split[1]); // 무게 합 제한
			
			snack = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			max = Integer.MIN_VALUE;

			comb(0, 0);

			sb.append(max + "\n");

		}
		System.out.println(sb);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == 2) {
			int sum = numbers[0] + numbers[1];
			if (M >= sum && sum > max) {
				max = sum;
				return;
			}
			if (max == Integer.MIN_VALUE) {
				max = -1;
				return;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = snack[i];
			comb(cnt+1, i+1);
		}
		
	}
}
