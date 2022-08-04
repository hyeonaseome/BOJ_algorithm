import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			sb.append(1);
		} else {
			int two = 2;
			
			while ( N > two) {
				two *= 2; 
			}

			sb.append((N - two/2) * 2);
			
		}
		System.out.println(sb);
	}

}
