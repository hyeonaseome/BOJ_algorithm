import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int N, maxScore; // N: 이닝 수  N(2 ≤ N ≤ 50)
	private static int[][] players;
	private static int[] numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());

		players = new int[N][9];

		// 3번 선수는 고정, 나머지 선수 타순 변경 -> 최다 득점 타순 얻기

		// 1: 안타, 2: 2루타, 3: 3루타: 4: 4루타, 0: 아웃
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				players[i][j] = Integer.parseInt(split[j]);
			}
		}

		// 순열 but, 0번이 3번으로 고정된 상태에서 시작
		// 야구 타순 결정
		numbers = new int[9];
		maxScore = 0;

		perm(0, 0);
		// 최고 점수 얻기
		sb.append(maxScore);
		System.out.println(sb);
	}

	private static void perm(int cnt, int visited) {
		// 기저 부분
		if (cnt == 9) {
			// 경기 시작!
			play();
			return;
		}
		// 유도 부분
		for (int i = 1; i < 9; i++) {
			if ((visited & (1 << i)) > 0) continue;
			numbers[cnt] = i;
			// 다음 번호
			if (cnt != 2) {
				perm(cnt + 1, visited | (1 << i));
			}else {
				perm(cnt + 2,  visited | (1 << i));
			}
		}
	}

	static void play() {
		int score = 0;
		int playerNum = 0; // 현재 타자의 번호s
		for (int i = 0; i < N; i++) {
			int out = 0;
			int base = 0;
			while (out < 3) {
				int curScore = players[i][numbers[playerNum]];
				if (curScore == 0)
					out++;
				else {
					base = (base + 1) << curScore;
					score += Integer.bitCount(base / 16);
					base %= 16;
				}
				playerNum = (playerNum + 1) % 9;
			}
		}
		// 경기끝  최고 점수 갱신
		if (maxScore < score) {
			maxScore = score;
		}
	}
}