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

	private static void play() {
		// 야구 시작
		int playerNum = 0; // 현재 타자의 번호
		int outCnt = 0; // 1이닝 3아웃시 이닝 종료

		boolean[] plates =  new boolean[4];// 0:홈 1: 1루 2: 2루, 3: 3루

		int score = 0;
		for (int i = 0; i < N; i++) { //N개의 이닝 소화
			while(outCnt < 3) {
				//현 타자의 점수
				int curScore = players[i][numbers[playerNum]];
				switch(curScore) {
				case 0: // 아웃
					outCnt++;
					break;
				case 1: // 타자와 모든 주자가 한 루씩 진루
					for (int j = 3; j >= 1; j--) {
						if(plates[j]) { // 주자가 있다면
							plates[j] = false;
							if(j >= 3) {// 득점권이라면
								score++;
							}else {
								plates[j + 1] = true; // 진루
							}
						}
					}
					// 타자 진루
					plates[1] = true;
					break;
				case 2: // 타자와 모든 주자가 두 루씩 진루
					for (int j = 3; j >= 1; j--) {
						if(plates[j]) { // 주자가 있다면
							plates[j] = false;
							if(j >= 2) {// 득점권이라면
								score++;
							}else {
								plates[j + 2] = true; // 진루
							}
						}
					}
					// 타자 진루
					plates[2] = true;
					break;
				case 3: // 타자와 모든 주자가 세 루씩 진루
					for (int j = 3; j >= 1; j--) {
						if(plates[j]) { // 주자가 있다면
							plates[j] = false;
							score++;
						}
					}
					// 타자 진루
					plates[3] = true;
					break;
				case 4: // 타자와 모든 주자가 홈까지 진루
					for (int j = 3; j >= 1; j--) {
						if(plates[j]) { // 주자가 있다면
							score++;
						}
					}
					// 타자도 점수
					score++;
					plates =  new boolean[4];
					break;
				}

				// 다음 타자로
				playerNum = (playerNum + 1) % 9;
			}
			outCnt = 0; // 다음 이닝을 위한 outCnt초기화
			plates =  new boolean[4];
		}
		
		// 경기끝  최고 점수 갱신
		if (maxScore < score) {
			maxScore = score;
		}
	}
}