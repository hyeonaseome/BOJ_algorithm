import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max, min, N;
	static int[] opers; // +, -, *, /
	static int[] input;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		input = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		opers = new int[4];

		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());
		}

		perm(0, input[0]);

		sb.append(max).append("\n");
		sb.append(min);

		System.out.println(sb);
	}
	private static void perm(int cnt, int answer) {
		// 기저 조건
		if (cnt == N - 1) {
			max = Math.max(answer, max);
			min = Math.min(answer, min);
			return;
		}
		// 유도 조건
		// + 
		if (opers[0] > 0) {
			// operator 하나 사용
			opers[0]--;
			perm(cnt + 1, answer + input[cnt + 1]);
			opers[0]++;
		}
        // -
		if (opers[1] > 0) {
			opers[1]--;
			perm(cnt + 1, answer - input[cnt + 1]);
			opers[1]++;
		}
        // *
		if (opers[2] > 0) {
			opers[2]--;
			perm(cnt + 1, answer * input[cnt + 1]);
			opers[2]++;
		}
        // /
		if (opers[3] > 0) {
			opers[3]--;
			if (answer > 0) {
				perm(cnt + 1, answer / input[cnt + 1]);
			}else {
				perm(cnt + 1, (-1) * ((-1 * answer) / input[cnt + 1]));
			}			

			opers[3]++;
		}
	}
}
