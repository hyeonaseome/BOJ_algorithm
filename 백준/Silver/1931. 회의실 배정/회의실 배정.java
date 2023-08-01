import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	private static int START = 0;
	private static int END = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 회의의 수 N(1 ≤ N ≤ 100,000)
		int N = Integer.parseInt(in.readLine());

		int[][] meetings = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			meetings[i][START] = Integer.parseInt(split[0]);
			meetings[i][END] = Integer.parseInt(split[1]);
		}

		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[END] != o2[END])
					return o1[END] - o2[END];

				return o1[START] - o2[START];
			}

		});

		int cnt = 1;
		int end = meetings[0][END];
		for (int i = 1; i < N; i++) {
			if (meetings[i][START] >= end) {
				end = meetings[i][END];
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}