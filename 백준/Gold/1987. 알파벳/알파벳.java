import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int R, C;
	private static char[][] board;
	private static int max = Integer.MIN_VALUE;
	private static boolean[] isvisit;

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
		isvisit = new boolean[26];

		int x = 0;
		int y = 0;
		move(x, y, 0);

		sb.append(max);
		System.out.println(sb);
	}
	private static void move(int x, int y, int cnt) {
		// 기저 부분 // 범위 밖이거나, 이미 방문한 알파벳인 경우
		if (!(0 <= x && x < R && 0 <= y && y < C) || isvisit[board[x][y] - 'A']) {
			if (cnt > max) {
				max = cnt;
			}
			return;
		}
		isvisit[board[x][y] - 'A'] = true;
		// 유도부분 
		for (int i = 0; i < 4; i++) {
			move(x + dx[i], y + dy[i], cnt+1);
		}
		isvisit[board[x][y] - 'A'] = false;

	}
}
