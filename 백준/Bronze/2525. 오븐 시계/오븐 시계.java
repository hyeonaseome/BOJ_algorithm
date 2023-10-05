import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String[] split = in.readLine().split(" ");
		int A = Integer.parseInt(split[0]);
		int B = Integer.parseInt(split[1]);
		int C = Integer.parseInt(in.readLine());
		
		int answer = A * 60 + B + C;
		int hour = ( answer / 60 ) % 24;
		int minutes = answer % 60;

		System.out.println(hour + " " + minutes);
	}
}