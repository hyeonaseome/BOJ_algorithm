import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] split = in.readLine().split(" ");
		int num1 = Integer.parseInt(split[0]);
		int num2 = Integer.parseInt(split[1]);

		int gcd = getGCD(num1, num2);
		int lcm = num1 * num2 / gcd;
		System.out.println(gcd + "\n" + lcm);
	}

	private static int getGCD(int num1, int num2) {
		int min = num1 > num2 ? num2 : num1;

		for (int i = min; i >= 2; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				return i;
			}
		}
		return 1;
	}
}