import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, min;
	static int[][] taste;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		// 재료의 개수
		N = Integer.parseInt(in.readLine());
		// 신맛 S, 쓴맛 B
		
		// 신맛: 곱, 쓴맛: 함, 차이를 작게, 재료는 적어도 하나
		taste = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			String[] split = in.readLine().split(" ");
			taste[i][0] = Integer.parseInt(split[0]);
			taste[i][1] = Integer.parseInt(split[1]);
		}
		isSelected = new boolean[N];
		
		min = Integer.MAX_VALUE;

		/**
		 * 2. 알고리즘 풀기
		 */
		subset(0);

		/**
		 * 3. 정답 출력
		 */
		sb.append(min);

		System.out.println(sb);
	}

	private static void subset(int index) {
		
		// 기저 부분
		if (index == N) {
			int sour = 1;
			int bitter = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sour *= taste[i][0];
					bitter += taste[i][1]; 
					flag = true;
				}
			}
			
			if (flag == true) {
				if (Math.abs(sour - bitter) < min) {
					min = Math.abs(sour - bitter);
				}
			}
			return;
			
		}
		
		// 유도 부분
		isSelected[index] = true;
		subset(index +1);
		
		isSelected[index] = false;
		subset(index +1);
	}
}
