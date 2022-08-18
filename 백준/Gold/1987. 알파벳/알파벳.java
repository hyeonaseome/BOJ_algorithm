import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	private static int R, C;
	private static char[][] board;
	private static int max = Integer.MIN_VALUE;
	private static ArrayList<Character> alphabet;

	// 우, 하, 좌, 상
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);

		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = in.readLine().toCharArray();
		}

		alphabet = new ArrayList<>();
		int x = 0;
		int y = 0;

		move(x, y, 0);

		/**
		 * 3. 정답 출력
		 */
		sb.append(max);
		System.out.println(sb);
	}
	private static void move(int x, int y, int cnt) {
		// 기저 부분
		// 범위 밖이거나, 이미 방문한 알파벳인 경우
		if (!(0 <= x && x < R && 0 <= y && y < C) || (alphabet.contains(board[x][y]))) {
			if (cnt > max) {
				max = cnt;
			}
			return;
		}
		
		alphabet.add(board[x][y]);
		// 유도부분 
		for (int i = 0; i < 4; i++) {
			move(x + dx[i], y + dy[i], cnt+1);
		}
		alphabet.remove(alphabet.size() -1);

	}
}
