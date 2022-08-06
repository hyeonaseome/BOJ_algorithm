import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			String str = in.readLine();
			if(str == null) {
				break;
			}
			
			String[] split = str.split(" ");
			int A = Integer.parseInt(split[0]);
			int B = Integer.parseInt(split[1]);
			int C = Integer.parseInt(split[2]);

			int count = 0;
			while(true) {
				if (C - A == 2) {
					break;
				}
				int tempB = B;
				if ( B - A > C - B) {
					B = A + 1;
					C = tempB;
				} else {
					B = C - 1;
					A = tempB;
				}
				count++;
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
}
