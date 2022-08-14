import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int K;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(in.readLine());
			K = Integer.parseInt(st.nextToken());
			if (K == 0) {
				break;
			}
			
			int[] S = new int[K];
			int[] P = new int[K];
			for (int i = 0; i < K; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i <6; i++) {
				P[i] = 1;
			}
			
			Arrays.sort(S);
			
			do {
				for (int i = 0; i < K; i++) {
					if(P[i] == 1) sb.append(S[i] + " ");
				}
				sb.append("\n");
			}while(np(P));
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static boolean np(int[] numbers) {
		int i = K - 1;
		while (i > 0 && numbers[i-1] <= numbers[i]) i--;
		if (i == 0) return false;
		
		int j = K - 1;
		while (numbers[i-1] <= numbers[j]) j--;
		swap(i-1, j, numbers);
		
		int k = K-1;
		while(i < k) swap(i++, k--, numbers);
		
		return true;
	}

	private static void swap(int a, int b, int[] numbers) {
		int temp = numbers[a];
		numbers[a] = numbers[b];
		numbers[b] = temp;		
	}
	
}
