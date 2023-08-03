import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int whiteCnt, blueCnt;
	private static int[][] board;
	private static int WHITE = 0;
	private static int BLUE = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 전체 종이의 한 변의 길이
		int N = Integer.parseInt(in.readLine());
		whiteCnt = 0;
		blueCnt = 0;
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int j = 0; j < N; j++) {
				board[i][j] = nums[j];
			}
		}

		rec(0, 0, N);

		sb.append(whiteCnt + "\n" + blueCnt);

		System.out.println(sb);
	}

	private static void rec(int startX, int startY, int n) {
		if (isALLColor(startX, startY, n, WHITE)) {
			whiteCnt++;
		} else if (isALLColor(startX, startY, n, BLUE)) {
			blueCnt++;
		} else {
			rec(startX, startY, n / 2);
			rec(startX + n / 2, startY, n / 2);
			rec(startX, startY + n / 2, n / 2);
			rec(startX + n / 2, startY + n / 2, n / 2);
		}

	}

	private static boolean isALLColor(int startX, int startY, int n, int color) {
		for (int i = startX; i < startX + n; i++) {
			for (int j = startY; j < startY + n; j++) {
				if (board[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
}