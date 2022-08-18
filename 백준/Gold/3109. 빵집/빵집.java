import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int R, C, count;
	private static char[][] map;

	// 우상, 우, 우하
	private static int[] dx = {-1, 0, 1};
	private static int[] dy = {1, 1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		R = Integer.parseInt(split[0]);
		C = Integer.parseInt(split[1]);
		count = 0;

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			getpipe(i, 0);
		}

		sb.append(count);
		System.out.println(sb);
	}
	private static boolean getpipe(int x, int y) {
		// 기저 부분
		if (y == C - 1) {
			count++;
			return true;
		}
		
		// 유도부분
		for (int i = 0; i < 3; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if(!(newX >= 0 && newX < R  && newY >= 0  && newY < C)) continue;
			if (map[newX][newY] == 'x') continue;
			map[x][y] = 'x';
			if (getpipe(newX, newY)) return true;
		}		
		return false;
	}
}
