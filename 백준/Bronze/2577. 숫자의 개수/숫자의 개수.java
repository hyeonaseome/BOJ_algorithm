import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int multiply = 1;
		int[] nums = new int[10];
		
		for (int i = 0; i < 3; i++) {
			multiply *= Integer.parseInt(in.readLine());
		}
		
		String mulStr = Integer.toString(multiply);
		for (int i = 0 ; i < mulStr.length(); i++) {
			nums[mulStr.charAt(i) - '0'] += 1;
		}
		
		for (int i = 0; i <= 9; i++) {
			sb.append(nums[i]).append("\n");
		}
		System.out.println(sb);
	}
}