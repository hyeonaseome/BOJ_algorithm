import java.io.BufferedReader;
import java.io.InputStreamReader;

// 부분집합
public class Solution {
	static int N, L, max_score;

	// 재료의 맛, 칼로리
	static int[][] food;
	static boolean[] isSelsected;
	public static void main(String[] args) throws Exception {

		/**
		 * 0. 입력파일 읽어들이기
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			/**
			 * 2. 알고리즘 풀기
			 */

			// N: 재료의 수, L: 제한 칼로리
			String[] split = in.readLine().split(" ");
			N = Integer.parseInt(split[0]);
			L = Integer.parseInt(split[1]);
			max_score = Integer.MIN_VALUE;

			// 재료의 맛, 칼로리
			food = new int[N][2];
			for (int i= 0; i <N; i++) {
				split = in.readLine().split(" ");
				food[i][0] = Integer.parseInt(split[0]);
				food[i][1] = Integer.parseInt(split[1]);
			}
			isSelsected = new boolean[N];
			subset(0);

			/**
			 * 3. 정답 출력
			 */
			sb.append(max_score + "\n");

		}
		System.out.println(sb);
	}
	private static void subset(int index) { // index: 부분집합에 고려할 대상
		if (index == N) {
			int sum = 0;
			int score = 0;
			for (int i = 0; i < N; i++) {
				sum += isSelsected[i] ? food[i][1] : 0;
				score += isSelsected[i] ? food[i][0] : 0;
			}
			
			if (sum <= L && score > max_score) {
				max_score = score;
			}
			return;
		}

		// 원소 선택
		isSelsected[index] = true;
		subset(index+1);
		// 원소 미선택
		isSelsected[index] = false;
		subset(index+1);
	}
}
