import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	private static int N, M, D, enemy, max;
	private static int[] numbers;
	private static int[][] map, copymap;
	private static List<int[]> Archerlists = new ArrayList<int[]>();
	private static Queue<int[]> deleteque =new LinkedList<>();

	/*// 좌, 상, 우
	static int[] dr= {0,-1,0}; //CW
	static int[] dc= {-1, 0,1};*/
	
	// 좌, 상, 우, 하
	static int[] dr= {0, -1,0,1}; //CW
	static int[] dc= {-1, 0,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		D = Integer.parseInt(split[2]);

		map = new int [N+1][M+1];
		copymap = new int [N+1][M+1];
		for (int i = 1; i < N+1; i++) {
			map[i] = Arrays.stream(("0 "+in.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		numbers = new int[3];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		/**
		 * 2. 알고리즘 풀기
		 */
		// 궁수 3명 배치 (조합)
		comb(0, 1);

		// 공격
		max = 0;
		for (int[] archers : Archerlists) {
			enemy = 0; // 죽인 적의 수
			//sb.append(Arrays.toString(archers)).append("-----------------------\n");
			
			for (int i = N + 1; i > 0; i--) {
				for (int j = 0; j < 3; j++) {
					// 각 궁수로 부터 가장 가까이 왼쪽에 있는 적 확인
					bfs(i,archers[j]);
					/*sb.append("enemy: "+enemy).append("\n");
					sb.append("("+i+", "+archers[j]+")").append("\n");
					for (int x = 0; x < N + 1; x++) {
						sb.append(Arrays.toString(map[x])).append("\n");
					}*/
				}
				//sb.append("size: "+ deleteque.size()+ "\n");
				while(!deleteque.isEmpty()){
					int [] cur=deleteque.poll();
					//sb.append(Arrays.toString(cur)).append("\n");
					int r=cur[0];
					int c=cur[1];
					if (map[r][c] == 1) enemy++;
					map[r][c] = 0;
				}
			}
			if (enemy > max) {
				max = enemy;
			}
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < M+1; j++) {
					map[i][j] = copymap[i][j];
				}
			}
		}

		/**
		 * 3. 정답 출력
		 */
		/*for (int i = 0; i < totalCnt; i++) {
			sb.append(Arrays.toString(Archerlists.get(i)) + "\n");
		}*/
		sb.append(max);
		System.out.println(sb);
	}

	private static void bfs(int rr, int cc) {
		Queue<int[]> que=new LinkedList<>();
		boolean [][] visited=new boolean[N + 2][M + 2];
		int K=0;     // 궁수 범위

		que.offer(new int[] {rr,cc});  //시작지점
		visited[rr][cc]=true;          //방문

		while(!que.isEmpty() && K <= D) {
			int size=que.size();       //K를 증가시키면서 
			for (int i = 0; i < size; i++) { // 현지점에 적이 있나
				int [] cur=que.poll();
				int r=cur[0];
				int c=cur[1];
				if(!(r == rr && c == cc) && map[r][c]==1) {
					// map[r][c] = 0; // 적을 죽임
					deleteque.add(new int[] {r, c});
					return;					
				}
				for (int d = 0; d < 4; d++) { //현지점의 3방으로 증가
					int nr=r+dr[d];
					int nc=c+dc[d];
					//if(!check(nr,nc))continue;
					if(!( nr> 0 && nr<rr && nc>0 && nc<=M)) continue;
					if(!visited[nr][nc]) {
						que.offer(new int[] {nr,nc});
						visited[nr][nc]=true;
					}
				}
			}
			K++;
		}
	}
	/*private static boolean check(int r, int c) {
		return r> 0 && r<=N && c>0 && c<=M;
	}*/
	private static void comb(int cnt, int start) {  // cnt : 직전 까지 뽑은 순열에 포함된 수의 개수

		if (cnt == 3) {
			int[] newNumbers = Arrays.copyOf(numbers, 3);
			Archerlists.add(newNumbers);
			return;
		}

		for (int i = start; i <= M; i++) {
			numbers[cnt] = i;

			comb(cnt+1, i+1);
		}

	}
}
