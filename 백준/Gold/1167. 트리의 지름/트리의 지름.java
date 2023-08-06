import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	private static class Node {
		int idx;
		int weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

	private static int y, max, V;
	private static ArrayList<Node>[] tree;
	private static boolean[] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(in.readLine());
		tree = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			tree[i] = new ArrayList<>();
		}
		isVisited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			int[] vertexes = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int start = vertexes[0];
			for (int j = 1; j < vertexes.length - 1; j += 2) {
				tree[start].add(new Node(vertexes[j], vertexes[j + 1]));
			}
		}

		y = -1;
		max = -1;
		dfs(1, 0);
		isVisited = new boolean[V + 1];
		max = -1;
		dfs(y, 0);

		System.out.println(max);

	}

	private static void dfs(int num, int sum) {
		isVisited[num] = true;

		if (sum > max) {
			y = num;
			max = sum;
		}

		for (int i = 0; i < tree[num].size(); i++) {
			Node cur = tree[num].get(i);
			if (isVisited[cur.idx])
				continue;

			dfs(cur.idx, sum + cur.weight);
		}
	}
}