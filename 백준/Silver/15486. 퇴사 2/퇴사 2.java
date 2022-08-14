import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		
		// 보통 시간 절약을 위해서 배열 생성후 값 을 더해나가는 방식 적용
		StringTokenizer st = new StringTokenizer(in.readLine());
		/** 1. 입력 파일 객체화 */
		int N = Integer.parseInt(st.nextToken());
		int[] T = new int[N + 2];
		int[] P = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int [] maxpay = new int [N + 2];
		
		/**
		 * 2. 알고리즘 풀기
		 */
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < N + 2; i++) {
			if (max < maxpay[i]) {
				max = maxpay[i];
			}
			
			int day = i + T[i];
			if (day < N + 2) {
				maxpay[day] = Math.max(maxpay[day], max + P[i]);
			}
		}

		/**
		 * 3. 정답 출력
		 */
		sb.append(max);
		System.out.println(sb);
	}
}
