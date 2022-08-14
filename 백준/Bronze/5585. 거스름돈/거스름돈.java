import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int money = Integer.parseInt(in.readLine());
		int n = 1000 - money;
		
		int result = 0;
		
		int[] coin = {500, 100, 50, 10, 5, 1};
		
		for (int i = 0; i < coin.length; i++) {
			result += n/coin[i];
			n %= coin[i];
		}
		
		System.out.println(result);
	}
}
