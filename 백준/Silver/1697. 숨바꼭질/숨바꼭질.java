import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
// BOJ 1697 숨바꼭질
// 그래프 BFS 탐색
public class Main {
	private static int mintime, N, K;
	private static boolean[] visited;
	private static int[] times;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		String[] split = in.readLine().split(" ");
		// 수빈이가 있는 위치
		N = Integer.parseInt(split[0]);
		// 동생이 있는 위치
		K = Integer.parseInt(split[1]);
		mintime = Integer.MAX_VALUE;

		visited = new boolean[100_001];
		times = new int[100_001];

		if (N >= K) {
			System.out.println(N - K);
		}else {
			bfs(N, 0);
			System.out.println(times[K]);
		}

		System.out.println(sb);
	}
	
	private static void bfs(int start, int time) {
		Queue<Integer> queue = new ArrayDeque<>();

		visited[start] = true;
		queue.offer(start);
		while(!queue.isEmpty()) {

			int n = queue.poll();
			if (n == K) return;
			
			if ((0 <= n*2 && n*2 < 100_001) && !visited[n * 2]) {
				visited[n * 2] = true;
				times[n * 2] = times[n] + 1;
				queue.offer(n * 2);
			}
			if ((0 <= n+1 && n+1 < 100_001) && !visited[n + 1]) {
				visited[n + 1] = true;
				times[n + 1] = times[n] + 1;
				queue.offer(n + 1);
			}
			if ((0 <= n-1 && n-1 < 100_001) && !visited[n - 1]) {
				visited[n - 1] = true;
				times[n - 1] = times[n] + 1;
				queue.offer(n - 1);
			}
		}
	}
}
