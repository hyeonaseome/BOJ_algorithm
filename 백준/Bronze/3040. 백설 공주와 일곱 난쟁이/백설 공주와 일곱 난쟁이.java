import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] numbers, dwarf;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		dwarf = new int[9];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(in.readLine());
		}
		numbers = new int[7];

		comb(0, 0, 0);
		System.out.println(sb);
	}

	private static void comb(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(numbers[i]);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			numbers[cnt] = dwarf[i];
			comb(cnt + 1, i +1, sum + numbers[cnt]);
		}
	}
}
