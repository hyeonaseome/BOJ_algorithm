import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		int[][] comb = new int[31][31];
		for (int i = 0; i < 31; i++) {
			for (int j = 0; j <= i; j++) {
				if(j==0|| j==i) {
					comb[i][j] = 1;
					continue;
				}
				
				comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
			}
		}

		int answer = comb[M - 1][M - N];
		sb.append(answer);

		System.out.println(sb);
	}
}
