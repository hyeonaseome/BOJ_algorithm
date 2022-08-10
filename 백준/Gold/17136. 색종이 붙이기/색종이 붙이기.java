import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int[][] map;
	static int count = 0;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		map = new int[10][10];

		/**
		 * 1. 입력 파일 객체화
		 */
		
		for (int i = 0; i < 10; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}


		/**
		 * 2. 알고리즘 풀기
		 */
		DFS(0, 0, 0);
		
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
        }

		/**
		 * 3. 정답 출력
		 */
		sb.append(answer);
		
		System.out.println(sb);
	}

	private static void DFS(int x, int y, int cnt) {
		// 맨 끝점에 도달하였을 경우, ans와 cnt 비교하고 종료.
		if (x >= 9 && y > 9) {
            answer = Math.min(answer, cnt);
            return;
        }
		
		if (answer <= cnt) {
			return;
		}
		
		// 아래 줄로 이동.
		if (y > 9) {
            DFS(x + 1, 0, cnt);
            return;
        }
		if (map[x][y] == 1) {
			for (int p = 5; p > 0; p--) {
				if (paper[p] > 0 && isAttach(x, y, p)) {
                    attach(x, y, p, 0); // 색종이를 붙임.
                    paper[p]--;
                    DFS(x, y + 1, cnt + 1);
                    attach(x, y, p, 1); // 색종이를 다시 뗌.
                    paper[p]++;
                }
			}
		}else { // 오른쪽으로 이동.
            DFS(x, y + 1, cnt);
        }		
	}

	private static boolean isAttach(int startX, int startY, int p) {
		if (!(0 <= startX + p && startX + p <= 10 &&
				0 <= startY + p && startY+ p <= 10 ) ) {
			return false;
		}
		for (int x = startX; x <startX + p ; x++) {
			for (int y = startY;  y < startY + p ; y++) {
				if(map[x][y] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void attach(int startX, int startY, int p, int n) {
		for (int x = startX; x <startX + p ; x++) {
			for (int y = startY; y < startY + p ; y++) {
				map[x][y] = n;
			}
		}
	}	
}
