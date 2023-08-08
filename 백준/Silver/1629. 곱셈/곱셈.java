import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		long[] nums = Arrays.stream(in.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

		System.out.println(pow(nums[0], nums[1], nums[2]));
	}

	private static long pow(long A, long B, long C) {
		long res = 1;
		while(B > 0) {
			if ((B & 1) == 1) {
				res = ((res % C) * (A % C)) % C;
			}
			A = ((A % C) * (A % C)) % C;
			B = B >> 1;
		}
		return res % C;
	}

}