import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int[][] map = new int [n+1][m+1];
		
		for (int i = 1; i < n+1; i++) {
			str = br.readLine().split(" ");
			for (int j = 1; j< m+1 ; j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		int k =  Integer.parseInt(br.readLine());
		int[] result = new int [k];
		
		for (int l = 0; l < k; l++) {
			str = br.readLine().split(" ");
			int i = Integer.parseInt(str[0]);
			int j = Integer.parseInt(str[1]);
			int x = Integer.parseInt(str[2]);
			int y = Integer.parseInt(str[3]);
			
			int sum = 0;
			
			for (int a = i; a <= x; a++) {
				for (int b = j; b<= y ; b++) {
					sum += map[a][b];
				}
			}
			
			result[l] = sum;
		}
		
		for (int l = 0; l < k; l++) {
			System.out.println(result[l]);
		}
		
	}
}