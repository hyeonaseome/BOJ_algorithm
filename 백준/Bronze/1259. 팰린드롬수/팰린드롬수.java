import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num  = br.readLine();
		String result = "yes";
		
		while (!(num.equals("0"))) {
			for (int i = 0; i < num.length(); i++) {
				if (num.charAt(i) != num.charAt(num.length() -1 - i)) {
					result = "no";
					break;
				}
			}
			System.out.println(result);
			result = "yes";
			num = br.readLine();
		}
	}
	
}
