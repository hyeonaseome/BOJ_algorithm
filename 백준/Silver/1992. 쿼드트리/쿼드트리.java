import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	private static int[][] picture;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// N: 영상의 크기, 2의 제곱수 (1 <= N  <= 64)
		int N = Integer.parseInt(in.readLine());

		// 흑백 영상
		picture = new int [N][N];
		for (int i = 0; i < N; i++) {
			String s = in.readLine();
			for (int j = 0; j < N; j++) {
				picture[i][j] = s.charAt(j) - '0';
			}
		}

		cut(0, 0, N);

		System.out.println(sb);
	}

	// r: 탐색 시작점의 행, c: 탐색 시작지점의 열, size: 탐색 영역 한 변의 길이
	// 흑: 1, 백: 0
	private static void cut(int r, int c, int size) {
		// 해당 영역의 색상 확인
		int sum = 0;
		for (int i = r; i < r +size; i++) {
			for (int j = c; j < c + size; j++) {
				sum += picture[i][j];
			}
		}
		// 전체 영역이 흑이면 (기저 부분)
		if (sum == size * size) {
			sb.append(1);
		}
		// 전체 영역이 백이면 (기저 부분)
		else if (sum == 0) {
			sb.append(0);
		}

		// 유도 부분
		else { // 색상이 섞여 있는 경우
			int half = size / 2;

			sb.append("(");
			cut(r, c, half); 		 	 // 좌상
			cut(r, c+half, half); 		 // 우상
			cut(r + half, c, half); 	 // 좌하
			cut(r + half, c+half, half); // 우하
			sb.append(")");
		}
	}


}
