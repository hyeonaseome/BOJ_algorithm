import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		while(true) {
			StringTokenizer st;
			try {
				st = new StringTokenizer(in.readLine());
			} catch (Exception e) {
				break;
			}
			
			// 모기 수
			int M = Integer.parseInt(st.nextToken());
			// 번데기 수
			int P = Integer.parseInt(st.nextToken());
			// 유충 수
			int L = Integer.parseInt(st.nextToken());
			// 한 모기가 낳는 알의 수
			int E = Integer.parseInt(st.nextToken());
			// 살아남는 유충 비율
			int R = Integer.parseInt(st.nextToken());
			// 살아남는 번데기 비율
			int S = Integer.parseInt(st.nextToken());
			// 모기 수를 구하려는 시점 (N주 후)
			int N = Integer.parseInt(st.nextToken());
			/**
			 * 2. 알고리즘 풀기
			 */
			for (int i = 1; i <= N; i++) {
				int newL = M * E;
				int newP = L / R;
				int newM = P / S;
				L = newL;
				P = newP;
				M = newM;
			}
			
			/**
			 * 3. 정답 출력
			 */
			// N번째 일요일 수의 모기 수
			sb.append(M + "\n");
		}

		System.out.println(sb);
	}
}
