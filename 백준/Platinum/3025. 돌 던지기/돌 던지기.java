import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	private static char space = '.';
	private static char wall = 'X';
	private static char rock = 'O';
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int R = Integer.parseInt(st.nextToken()); // 1 <= R <= 30_000
		int C = Integer.parseInt(st.nextToken()); // 1 <= C <= 30
		
		char[][] board = new char [R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			board[i] = st.nextToken().toCharArray();
		}
		
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 돌을 던진 횟수
		int[] throwRock = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			// 열번호를 바꾸기 위해 -1을 함
			throwRock[i] = Integer.parseInt(st.nextToken()) -1 ;
		}
		
		
		// 각 열마다 시작위치를 저장 (0으로 초기화된 상태)
		column[] reRoute = new column [C];
		for(int i = 0; i < C; i++) {
			reRoute[i] = new column(i);
			reRoute[i].route.add(new loc(0, i));
		}
		
		// 돌을 맵에 쌓기
		for (int i = 0; i < N; i++) {
			
			// 던지는 열의 위치
			int startC = throwRock[i];
			
			int rockR;
			int rockC;
			// 열의 시작 위치 찾기
			while(true) {
				rockR = reRoute[startC].route.peek().r;
				rockC = reRoute[startC].route.peek().c;
				if (board[rockR][rockC] == space) {
					break;
				}
				else {
					reRoute[startC].route.pop();
				}
			}
			
			while(true) {
				int below = rockR + 1;
				// 중력 1
				// 아랫칸이 벽 또는 가장 아랫줄이라면, 돌은 그자리에 멈춤
				if(rockR == R - 1||board[below][rockC] == wall) {
					board[rockR][rockC] = rock;
					break;
				}
				// 중력 2
				// 돌의 아랫칸이 비어있다면 아랫칸으로 이동
				else if (board[below][rockC] == space) {
					rockR = below;
					// 경로 추가
					int r = below;
					int c = rockC;
					reRoute[startC].route.push(new loc(r, c));
				}
				// 중력 3
				// 돌의 아랫칸에 돌이 있다면, 돌은 다음과 같이 미끄러진다.
				else if (board[below][rockC] == rock) {
					// 돌의 왼쪽칸과 왼쪽 아래칸이 비어있는 지 확인
					if (0 <= rockC -1 && board[rockR][rockC - 1] == space 
							&& board[below][rockC - 1] == space) {
						rockC = rockC - 1;
					}
					// 돌이 왼쪽 미끄러지지 않았고
					// 오른쪽칸과 오른쪽 아래칸이 비었는지 확인
					else if (rockC + 1 < C  && board[rockR][rockC + 1] == space 
							&& board[below][rockC + 1] == space) {
						rockC = rockC + 1;
					}
					// 두 경우가 아니라면 돌은 그자리에 멈춤
					else {
						board[rockR][rockC] = rock;
						break;
					}
				}
			}
		}
		for (int k = 0; k < R; k++) {
			sb.append(String.valueOf(board[k])).append("\n");
		}
		System.out.println(sb);
	}
	
	static class column{
		public int no;
		public Stack<loc> route = new Stack<>();
		public column(int no) {
			this.no = no;
		}
	}
	static class loc{
		public int r;
		public int c;
		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "(" + r + "," + c + ")";
		}
	}
}
