import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		
		int sum = 0;
		
		for (int i = 0; i < split.length; i++) {
			sum += Math.pow(Integer.parseInt(split[i]), 2);
		}
		
		System.out.println(sum%10);
	}
}