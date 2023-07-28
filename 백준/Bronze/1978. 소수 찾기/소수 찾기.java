import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 수의 개수
		int N = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (checkPrime(Integer.parseInt(split[i]))) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static boolean checkPrime(int num) {

		if (num == 1 || (num > 2 && num % 2 == 0))
			return false;
		for (int i = 3; i <= Math.sqrt(num); i=i+2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}