import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = in.readLine();
		String[] split;
		int[] nums = new int[3];

		while (!str.equals("0 0 0")) {
			split = str.split(" ");
			nums[0] = Integer.parseInt(split[0]);
			nums[1] = Integer.parseInt(split[1]);
			nums[2] = Integer.parseInt(split[2]);

			Arrays.sort(nums);

			if (nums[2] * nums[2] == nums[1] * nums[1] + nums[0] * nums[0]) {
				sb.append("right");
			} else {
				sb.append("wrong");
			}
			sb.append("\n");

			str = in.readLine();
		}

		System.out.println(sb);
	}
}