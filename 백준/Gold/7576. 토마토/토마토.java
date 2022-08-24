import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// BOJ 7576 토마토
public class Main {
	private static int[][] map;  // 토마토 상자
	private static int raw_tomatoesCnt; // 익지 않은 토마토 수
	
	private static int N, M, answer;
	private static Queue<Node> queue;
	private static boolean[][] isVisited;
	
	// 우, 하, 좌, 상
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};
	
	private static class Node{
		public int x;
		public int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수 //  2 ≤ M,N ≤ 1,000 
		String[] split = in.readLine().split(" ");
		M = Integer.parseInt(split[0]);
		N = Integer.parseInt(split[1]);
		
		map = new int[N][M];
		queue = new ArrayDeque<>();
		isVisited = new boolean[N][M];
		
		raw_tomatoesCnt =  0;
		answer = 0;
		
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(split[j]);
				switch(map[i][j]) {
				case 1:
					queue.offer(new Node(i, j));
					break;
				case 0:
					raw_tomatoesCnt++;
					break;
				}
			}
		}
		if (raw_tomatoesCnt == 0) {
			
		}

		bfs();

		if(raw_tomatoesCnt > 0) {
			sb.append(-1);
		}else {
			sb.append(answer);
		}
		System.out.println(sb);
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			int size = queue.size();
			if (raw_tomatoesCnt == 0) {
				return;
			}
			answer++;
			while(--size >= 0) {
				Node curNode = queue.poll();
				int curX = curNode.x;
				int curY = curNode.y;
				
				for (int i = 0; i < 4; i++) {
					int testX = curX + dx[i];
					int testY = curY + dy[i];
					
					if ( 0 <= testX && testX < N && 0 <= testY && testY < M && map[testX][testY] == 0) {
						queue.offer(new Node(testX, testY));
						isVisited[testX][testY] = true;
						if(map[testX][testY] == 0) {
							map[testX][testY] = 1;
							raw_tomatoesCnt--;
						}
					}
				}
			}
		}
	}
}
