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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			board[i] = st.nextToken().toCharArray();
		}
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());

		Row [] thorwRows = new Row[C];
		for (int i = 0; i < C; i++) {
			thorwRows[i] = new Row();
			thorwRows[i].route.add(new loc(0, i));
		}


		for (int i = 0; i< N ; i++) {
			st = new StringTokenizer(in.readLine());
			int throwRow = Integer.parseInt(st.nextToken()) - 1;
			int rockR = 0;
			int rockC = throwRow;
			while(true) {
				rockR = thorwRows[throwRow].route.peek().r;
				rockC = thorwRows[throwRow].route.peek().c;
				if (board[rockR][rockC] == space) {
					break;
				}else {
					thorwRows[throwRow].route.pop();
				}
			}

			while(true) {
				if (rockR == R - 1||board[rockR + 1][rockC] == wall) {
					board[rockR][rockC] = rock;
					break;
				}
				else if(board[rockR + 1][rockC] == space){
					rockR = rockR + 1;
					thorwRows[throwRow].route.add(new loc(rockR, rockC));
				}
				else if (board[rockR + 1][rockC] == rock) {
					if(rockC - 1 >= 0 && board[rockR][rockC - 1] == space && board[rockR + 1][rockC - 1] == space) {
						rockC = rockC - 1;
					}
					else if(rockC + 1 < C && board[rockR][rockC + 1] == space && board[rockR + 1][rockC + 1] == space) {
						rockC = rockC + 1;
					}
					else {
						board[rockR][rockC] = rock;
						break;
					}
				}
			}
		}

		for (int i = 0; i < R; i++) {
			sb.append(String.valueOf(board[i])).append("\n");
		}
		System.out.println(sb);
	}
	static class Row {
		Stack<loc> route = new Stack<>();		
	}

	static class loc {
		public int r;
		public int c;
		public loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "(" + r + ", " + c + ")";
		}
	}
}
