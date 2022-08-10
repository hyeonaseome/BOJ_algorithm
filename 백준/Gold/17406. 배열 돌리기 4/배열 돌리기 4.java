import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M, K;
	static int[][] commands;
	static int[][] dataOrigin;
	static int[][] data;
	static boolean[] isSelected;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 배열 A의 크기 N, M, 회전 연산의 개수 K
		String[] split = in.readLine().split(" ");
		N = Integer.parseInt(split[0]);
		M = Integer.parseInt(split[1]);
		K = Integer.parseInt(split[2]);
		data = new int[N + 1][M + 1];
		for (int i = 1 ; i<= N; i++) {
			data[i] = Arrays.stream(("0 "+in.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		dataOrigin  = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dataOrigin[i][j] = data[i][j];
			}
		}

		commands = new int[K][3];
		for (int i = 0 ; i< K; i++) {
			commands[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		isSelected = new boolean[K];
		numbers = new int[K];
		perm(0);
		sb.append(min+ "\n");

		System.out.println(sb);
	}

	private static void perm(int cnt) {
		if (cnt == K) {
			for (int i : numbers) {
				int r = commands[i][0];
				int c = commands[i][1];
				int s = commands[i][2];
				rotate(r, c, s);
			}
			
			// 배열의 값
			for (int i = 1; i  <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += data[i][j];
				}
				if (sum < min) {
					min = sum;
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					data[i][j] = dataOrigin[i][j];
				}
			}
			return;
		}
		
		for (int i = 0; i < K; i++) {
			
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
			
			isSelected[i] = false;
			
		}
	}

	private static void rotate(int r, int c, int s) {
		for (int j = 0; j < s; j++) {
			int startX = r - s + j;
			int startY = c - s + j;

			int endX = r+s - j;
			int endY = c+s - j;

			int temp = data[startX][startY];

			// 슬라이딩 퍼즐 처럼 생각하기!
			// 좌변: 아랫쪽에서 윗쪽 이동
			for (int i = startX; i < endX; i++) {
				data[i][startY] = data[i + 1][startY];
			}
			// 밑변: 오른쪽에서 왼쪽 이동
			for (int i = startY; i < endY; i++) {
				data[endX][i] = data[endX][i+1];
			}

			// 우변: 윗쪽에서 아랫쪽 이동
			for (int i = endX; i > startX; i-- ) {
				data[i][endY] = data[i - 1][endY];
			}

			// 윗변: 왼쪽에서 오른쪽 이동
			for (int i = endY; i > startY; i--) {
				data[startX][i] = data[startX][i - 1];
			}

			// 처음 빼낸 값을 다시 넣기
			data[startX][startY + 1] = temp;
		}		
	}
}
