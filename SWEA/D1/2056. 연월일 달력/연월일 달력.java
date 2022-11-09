import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int[] valid = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			String inputS = in.readLine();

			String year = inputS.substring(0, 4);
			String month = inputS.substring(4, 6);
			int monthInt = Integer.parseInt(month);
			String day = inputS.substring(6, 8);
			int dayInt = Integer.parseInt(day);

			if (1 <= monthInt && monthInt <= 12 && 1 <= dayInt && dayInt <= valid[monthInt]) {
				sb.append(year + "/" + month + "/" + day).append("\n");
			} else {
				sb.append(-1).append("\n");
			}

		}
		System.out.println(sb);
	}
}