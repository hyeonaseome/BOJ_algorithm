import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		int[] nums = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
        
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += nums[i] * (N - i);
		}

		sb.append(answer);
		System.out.println(sb);
	}
}
