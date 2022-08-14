import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] isSelected;
	static int[][] consult;
	static boolean[] notconsult;
	static int maxsum;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		/** 1. 입력 파일 객체화 */
		N = Integer.parseInt(st.nextToken());
		maxsum = Integer.MIN_VALUE;
		consult = new int[N][2];
		isSelected = new boolean[N];

		notconsult = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
			if (consult[i][0] > (N - i)) {
				notconsult[i] = true;
			}
		}

		/** 2. 알고리즘 풀기 */
		subset(0);
		/** 3. 정답 출력 */
		sb.append(maxsum);

		System.out.println(sb);
	}
	private static void subset(int index) {
		if (index == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(isSelected[i] && !notconsult[i]) {
					sum += consult[i][1];
				}
			}
		
			if (sum > maxsum) {
				maxsum = sum;
			}
			return;
		}
		// 원소 선택
		isSelected[index] = true;
		// 조건 달기
		int nextindex = index + consult[index][0];
		boolean flag = false;
		for (int i = index + consult[index][0]; i < N; i++) {
			if (!notconsult[i]) {
				nextindex = i;
				flag = true;
				break;
			}
		}
		if(!flag) {
			nextindex = N;
		}
		subset(nextindex);
		// 원소 미선택
		isSelected[index] = false;
		subset(index + 1);
	}
}
