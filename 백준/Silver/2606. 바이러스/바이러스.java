import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int N;
	private static boolean[] isVisited;
	private static boolean[][] connect;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 컴퓨터의 수
		N = Integer.parseInt(in.readLine());
		// 네트워크상 직접 연결되어 있는 컴퓨터 쌍수
		int M = Integer.parseInt(in.readLine());

		isVisited = new boolean[N];
		connect = new boolean[N][N];

		for (int i = 0; i < M; i++) {
			String[] split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0]) - 1;
			int end = Integer.parseInt(split[1]) - 1;

			connect[start][end] = true;
			connect[end][start] = true;
		}
        
        // 1을 0 인덱스로 봄
		dfs(0);

		int count = 0;
		for (int i = 1; i < N; i++) {
			if (isVisited[i])
				count++;
		}

		System.out.println(count);
	}

	private static void dfs(int num) {
		isVisited[num] = true;

		for (int i = 0; i < N; i++) {
			if (isVisited[i])
				continue;
			if (!connect[num][i])
				continue;

			dfs(i);
		}

	}
}