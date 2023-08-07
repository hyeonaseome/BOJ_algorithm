import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int N;
	private static int[][] adjMatrix;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");

		N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int X = Integer.parseInt(split[2]) - 1;

		adjMatrix = new int[N][N];
		for (int i = 0; i < M; i++) {
			split = in.readLine().split(" ");
			int s = Integer.parseInt(split[0]) - 1;
			int e = Integer.parseInt(split[1]) - 1;
			int time = Integer.parseInt(split[2]);
			adjMatrix[s][e] = time;
		}

		int[] times = new int[N];
		int max = 0;
		for (int start = 0; start < N; start++) {
			times[start] = startToEnd(start, X);
		}

		for (int end = 0; end < N; end++) {
			times[end] += startToEnd(X, end);
			max = Math.max(times[end], max);
		}

		System.out.println(max);
	}

	private static int startToEnd(int start, int end) {
		int[] D = new int[N];
		boolean[] visited = new boolean[N];

		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;

		int min, minVertex;

		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < N; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}

			visited[minVertex] = true;
			if (minVertex == end)
				break;

			for (int j = 0; j < N; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
					D[j] = D[minVertex] + adjMatrix[minVertex][j];
				}
			}
		}
		return D[end];
	}
}