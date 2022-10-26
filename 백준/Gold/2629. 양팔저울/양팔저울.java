import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int n;
	
	private static boolean[][] D;
	private static int[] weight;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		
		n = Integer.parseInt(in.readLine()); // 추의 개수
		
		weight = new int[n];
		D = new boolean [31][15001];
		
		String[] split = in.readLine().split(" ");
		for (int i = 0; i< n; i++) {
			weight[i] = Integer.parseInt(split[i]);
		}
		
		dp(0, 0);
		
		int checkN = Integer.parseInt(in.readLine());
		
		split = in.readLine().split(" ");
		for (int i = 0; i < checkN; i++) {
			int checkW = Integer.parseInt(split[i]);
			if(checkW > 15000 || !D[n][checkW]) {
				sb.append("N ");
			}else {
				sb.append("Y ");
			}
		}
		
		System.out.println(sb);
		
	}
	private static void dp(int cnt, int num) {
		
		if(D[cnt][num]) return;
		D[cnt][num] = true;

		if(cnt == n	) return;
		
		dp(cnt+1, num + weight[cnt]); // 추를 구슬이 있는 저울에
		dp(cnt+1, num ); // 추를 사용하지 않음
		dp(cnt+1, Math.abs(num - weight[cnt])); // 추를 구슬이 없는 저울에
		
	}
}