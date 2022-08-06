import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int count = 1;
		while(true) {
			String str = in.readLine();
			if(str.equals("0 0 0")) {
				break;
			}
			
			String[] lpv = str.split(" ");
			int L = Integer.parseInt(lpv[0]);
			int P = Integer.parseInt(lpv[1]);
			int V = Integer.parseInt(lpv[2]);

			// 1 < L < P < V
			int quotient =  V/P ;
			int remainder = V % P > L ? L : V % P;
			
			int answer = quotient * L + remainder;

			sb.append("Case "+ count + ": " + answer+"\n");
			count++;	
		}
		System.out.println(sb);
	}
}
