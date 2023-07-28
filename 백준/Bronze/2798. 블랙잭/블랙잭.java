import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int N, M, maxSum;
	public static int[] inputs;
	public static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		maxSum = 0;
		inputs = new int[N];
		isSelected = new boolean[N];

		split = in.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(split[i]);
		}

		selectThreeCard(0, 0);
		System.out.println(maxSum);
	}

	private static void selectThreeCard(int cnt, int sum) {

		if (cnt == 3) {
			if (maxSum < sum) {
				maxSum = sum;
			}
			return;
		}

		if (maxSum == M) {
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;

			if (sum + inputs[i] <= M) {
				isSelected[i] = true;
				selectThreeCard(cnt + 1, sum + inputs[i]);
				isSelected[i] = false; // 다시 원상태로 돌리기
			}
		}
	}
}