import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 10971 외판원 순회 2
public class Main {
	private static int N, start;
	private static int[][] adjMatrix;
	private static boolean[] visited;
	private static int[] Numbers;
	private static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine()); // 도시의 수

		visited = new boolean[N];
		Numbers = new int[N];
		adjMatrix = new int[N][N]; //  1부터 N까지
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = Integer.MAX_VALUE;
		visited[0] = true;
		
		perm(1);
		
		sb.append(answer);
		System.out.println(sb);
	}

	private static void perm(int cnt) {

		// 기저조건
		if (cnt == N) {
			if (adjMatrix[Numbers[N - 1]][Numbers[0]] == 0) return;
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += adjMatrix[Numbers[i]][Numbers[i + 1]];
			}
			
			sum += adjMatrix[Numbers[N - 1]][Numbers[0]];
			if (sum < answer) {
				answer = sum;
			}
			return;
		}
		
		for (int i = 1; i < N; i++) {
			if(!visited[i] && adjMatrix[Numbers[cnt - 1]][i] != 0) { // 방문하지 않았으며 인접한 경우
				visited[i] = true;
				Numbers[cnt] = i;
				perm(cnt + 1);
				visited[i] = false;
			}
		}

	}
}
