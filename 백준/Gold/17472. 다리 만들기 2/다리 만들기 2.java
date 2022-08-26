import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 17472 다리 만들기 2
// Kruskal, 최소 스패닝 트리 , 섬인지 확인: 깊이 or 너비 탐색
public class Main {
	private static int N, M, idx;
	private static int[][] map;
	private static boolean[][][] visited;
	private static Island[] Islands;
	private static List<Edge> Edges;
	
	private static int V, E;
	private static int[] parents;
	
	// make 크기가 1인 집합
	private static void make() {
		parents = new int[V];
		
		for (int i = 2; i < V; i++) {
			parents[i] = i;
		}
	}
	// find : a의 대표자 찾기
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	// union
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA == rootB) return false;
		
		// 부모 교체
		parents[rootB] = rootA; 
		return true;
		
	}
	private static class Island {
		public int no;
		public List<loc> lands = new ArrayList<>();
		public Island(int no) {
			this.no = no;
		}
		@Override
		public String toString() {
			return "Island [no=" + no + ", lands=" + lands + "]";
		}
		
		
	}
	private static class loc{
		public int x;
		public int y;
		
		public loc(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	private static class Edge implements Comparable<Edge>{
		public int from;
		public int to;
		public int weight; // 여기서는 다리의 길이
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);  // 오름차순
		}
	}
	
	//  우, 하, 좌, 상
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/**
		 * 2. 알고리즘 풀기
		 */
		Islands = new Island [8]; // 2,3,4,5,6,7 번호를 가진 섬 생성가능
		
		idx = 2;
		// 섬을 구분 짓기 (bfs 탐색) 섬을 Vertex처럼
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					Islands[idx] = new Island(idx);
					bfs(i, j);
					idx++;
				}
			}
		}
		
		Edges = new ArrayList<>();
		
		// 각 섬을 하나씩 꺼내서 간선(Edge) 만들기 (dfs)
		
		for (int i = 2; i < idx; i++) {
			List<loc> locs = Islands[i].lands;
			for (int j = 0; j < locs.size(); j++) {
				visited = new boolean[N][M][2];
				loc curLoc = locs.get(j);
				// 한 방향으로만 움직임
				for (int k = 0; k < 4; k++) {
					dfs(Islands[i].no, curLoc.x, curLoc.y, k, 0);
				}
			}
		}
				
		// 다리 출력 (무방향)
		Collections.sort(Edges);
		
		// make
		V = idx;
		make();
		
		// union - find kruskalTest
		int result = 0; 
		int count = 0;
		for (Edge edge : Edges) {
			if (union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == V - 2) break;
			}
		}
		
		HashSet<Integer> parentsSet = new HashSet<>();
		for (int i = 2; i < idx; i++) {
			int a = find(i);
			parentsSet.add(a);
		}
		
		/**
		 * 3. 정답 출력
		 */
		if (parentsSet.size()  != 1) {
			sb.append("-1");
		} else {
			sb.append(result);
		}
		System.out.println(sb);
	}
	private static void dfs(int no, int x, int y, int dir, int cnt) {
		// 기저 조건
		if (map[x][y] != no && map[x][y] != 0) {
			if(cnt > 2) {
				Edges.add(new Edge(no, map[x][y], cnt - 1));
			}
			return;
		}
		
		// 유도 조건 (4방 탐색 중 한방향으로만 계속)
		int testX = x + dx[dir];
		int testY = y + dy[dir];
		if(0 <= testX &&testX < N && 0 <= testY && testY < M && map[testX][testY] != no && !visited[testX][testY][dir % 2]) {
			visited[testX][testY][dir % 2] = true; // 방문 처리
			dfs(no, testX, testY, dir, cnt + 1);
		}
	}
	private static void bfs(int startX, int startY) {
		Queue<loc> queue = new ArrayDeque<>();
		
		queue.offer(new loc(startX, startY));
		map[startX][startY] = idx;
		// 섬 추가
		Islands[idx].lands.add(new loc (startX, startY));
		
		while(!queue.isEmpty()) {
			loc cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;
			
			for (int i = 0; i < 4; i++) {
				int testX = curX + dx[i];
				int testY = curY + dy[i];
				
				// 범위 안
				if(0 <= testX &&testX < N && 0 <= testY && testY < M && map[testX][testY] == 1) {
					map[testX][testY] = idx;
					queue.offer(new loc(testX, testY));
					Islands[idx].lands.add(new loc(testX, testY));
				}
			}
		}
		
		
	}
}
