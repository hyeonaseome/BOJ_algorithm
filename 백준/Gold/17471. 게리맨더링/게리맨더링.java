import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] people;
	static int min;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());

		people = new int[N + 1]; // 1 based
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int pp = Integer.parseInt(st.nextToken());
			people[i] = pp;
		}
		// init list
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int node = Integer.parseInt(st.nextToken());
				list.get(i).add(node);
				list.get(node).add(i);
			}
		}
        // 모든 인구 수 
		int totalPeople = 0;
		for(int i=1;i<=N;i++) {
			totalPeople += people[i];
		}
		min = totalPeople;
        
		subset(1, new boolean[N + 1]);
		// 최소값이 모든 인구 수라는 건, 구역을 못나눴다는 의미
		if(min == totalPeople) System.out.println(-1);
		else System.out.println(min);

	}
// 부분집합
	static void subset(int cnt, boolean[] isSelected) {
		if (cnt == N + 1) {
			// 선택한거 : isSelected의 true false로 나눠짐
			boolean[] visited = new boolean[cnt];
			int check = 0;
			for (int i = 1; i < cnt; i++) {
				if (!visited[i]) {
					// i 번 노드에서 시작해서 구역 내 연결되었는지 확인
					dfs(i, visited, isSelected);
					check++;
				}
			}
			// 두 곳이 연결되어 있다면
			if (check == 2) {
				int sum1 = 0, sum2 = 0;
				for (int i = 0; i < cnt; i++) {
					if (isSelected[i])
						sum1 += people[i];
					else
						sum2 += people[i];
				}
				int diff = Math.abs(sum1 - sum2);
				min = Math.min(min, diff);
			}
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1, isSelected);

		isSelected[cnt] = false;
		subset(cnt + 1, isSelected);

	}

	// 구역 내 점들이 다 연결되어있는지
	static void dfs(int idx, boolean[] visited, boolean[] isSelected) {
		if (idx > N)
			return;

		visited[idx] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && isSelected[i] == isSelected[idx] && list.get(idx).contains(i)) {
				dfs(i, visited, isSelected);
			}
		}
	}
}