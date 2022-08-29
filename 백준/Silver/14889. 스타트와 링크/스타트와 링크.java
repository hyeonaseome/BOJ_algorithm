import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, min;
	private static int[] numbers;
	private static int[][] S;
	private static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		S = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		numbers = new int[N/2];
		isSelected = new boolean[N];
		isSelected[0] = true;
		min = Integer.MAX_VALUE;
		// 1명은 고정시킨후 다른 한명 선택
		comb(1, 1);
		sb.append(min);

		System.out.println(sb);
	}

	private static void comb(int cnt, int start) {
		if (cnt == N/2) {
			int[] numbers2 = new int[N/2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!isSelected[i]) {
					numbers2[idx] = i;
					idx++;
				}
			}
			
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0 ;i < N/2; i++) {
				for (int j = i+1; j < N/2; j++) {
					sum1 += (S[numbers[i]][numbers[j]] + S[numbers[j]][numbers[i]]);
					sum2 += S[numbers2[i]][numbers2[j]] + S[numbers2[j]][numbers2[i]];
				}
			}
			
			min = Math.min(min, Math.abs(sum1 - sum2));
			return;
		}
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			numbers[cnt] = i;
			comb(cnt+1, i+1);
			isSelected[i] = false;
		}
	}
}