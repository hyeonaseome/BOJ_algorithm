import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
// BOJ 17281
import java.util.Queue;

public class Main {
	private static int N, maxScore; // N: 이닝 수  N(2 ≤ N ≤ 50)
	private static int[][] players;
	private static int[] numbers;
	private static boolean[] isVisited;
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

		// 순열, 0번이 타순 3번으로 고정된 상태에서 시작
		// 야구 타순 결정
		numbers = new int[9];
		isVisited = new boolean[9];
		maxScore = 0;

		perm(0);
		// 최고 점수 얻기
		sb.append(maxScore);
		/**
		 * 3. 정답 출력
		 */

		System.out.println(sb);
	}

	private static void perm(int cnt) {
		// 기저 부분
		if (cnt == 9) {
			// 경기 시작!
			play();
			return;
		}
		// 유도 부분
		for (int i = 1; i < 9; i++) {
			if (isVisited[i]) continue;

			// 선택되지 않은 번호
			isVisited[i] = true;
			numbers[cnt] = i;
			// 다음 번호
			if (cnt != 2) {
				perm(cnt + 1);
			}else {
				perm(cnt + 2);
			}
			// 선택 취소
			isVisited[i] = false;

		}
	}
	private static void play() {
		// 야구 시작
		int playerNum = 0; // 현재 타자의 번호
		int outCnt = 0; // 이닝당 3아웃시 이닝 종료
		
		Queue<Integer> plates = new ArrayDeque<>();

		int score = 0;
		for (int i = 0; i < N; i++) { //N개의 이닝 소화
			while(outCnt < 3) {//현 타자의 점수
				int curScore = players[i][numbers[playerNum]];
				
				if (curScore == 0) {
					outCnt++;
				} 
				else if (curScore == 4) {
					score += plates.size();
					score++;
					plates = new ArrayDeque<>();
				}
				else {
					int size = plates.size();
					while(--size >= 0) {
						int poll = plates.poll();
						if(poll + curScore >= 4) {
							score++;
						}else {
							plates.add(poll + curScore);
						}
					}
					plates.add(curScore);
				}

				// 다음 타자로
				playerNum = (playerNum + 1) % 9;
			}
			outCnt = 0; // 다음 이닝을 위한 outCnt초기화
			plates = new ArrayDeque<>(); // plates 초기화
		}
		
		// 경기끝  최고 점수 갱신
		if (maxScore < score) {
			maxScore = score;
		}
	}
}