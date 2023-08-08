import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		System.out.println(pow(nums[0], nums[1], nums[2]));
	}

	private static long pow(int A, int B, int C) {
		if (B == 1)
			return A % C;
		else {
			long x = pow(A, B/2, C) % C;
			if (B % 2 == 0) {
				return x * x % C;
			} else {
				return (x * x % C) * A % C;
			}
		}
	}

}