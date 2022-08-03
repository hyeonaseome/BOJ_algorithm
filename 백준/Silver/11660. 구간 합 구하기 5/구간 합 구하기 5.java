import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		
		int[][] sums = new int [N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			split = in.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				sums[i][j] = sums[i][j-1] + sums[i-1][j] - sums[i-1][j-1] + Integer.parseInt(split[j-1]);
			}
		}
		
		
		for (int i = 1; i <= M; i++) {
			split = in.readLine().split(" ");
			int startX = Integer.parseInt(split[0]);
			int startY = Integer.parseInt(split[1]);
			int endX = Integer.parseInt(split[2]);
			int endY = Integer.parseInt(split[3]);
			
			int answer = sums[endX][endY] -  sums[endX][startY - 1] - sums[startX - 1][endY] +  sums[startX - 1][startY - 1];
			sb.append(answer + " \n");
		}
		
		System.out.println(sb);
	}

}
