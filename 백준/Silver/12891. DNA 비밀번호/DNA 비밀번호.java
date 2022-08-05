import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int S, P;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		// 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, 
		// ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용
		
		String[] split = in.readLine().split(" ");
		
		S = Integer.parseInt(split[0]);  // DNA 문자열 길이
		P = Integer.parseInt(split[1]);  // 비밀번호 길이 (부분 문자열 길이)
		String line = in.readLine();
		int[] condition = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] DNA_counts = new int[4];
		int count = 0;
		Queue<Character> queue = new ArrayDeque<>();
		for (int i = 0 ; i < P; i++) {
			char input = line.charAt(i);
			queue.offer(input);
			
			switch (input){
			case 'A':
				int k = 0;
				DNA_counts[k]++;
				break;
				
			case 'C':
				k = 1;
				DNA_counts[k]++;
				break;
			case 'G':
				k = 2;
				DNA_counts[k]++;
				break;
				
			case 'T':
				k = 3;
				DNA_counts[k]++;
				break;

			}
			
		}
		
		
		for (int j = 0; j <4; j++) {
			if (DNA_counts[j] >= condition[j]) {
				count++;
			}
		}
		
		int answer = 0;
		if (count == 4) {
			answer++;
		}
		for (int i = P; i < S; i++) {
			char input = line.charAt(i);
			queue.offer(input);

			char poll =  queue.poll();
			
			switch (poll){
			case 'A':
				int k = 0;
				DNA_counts[k]--;
				
				break;
			case 'C':
				k = 1;
				DNA_counts[k]--;
				
				break;

			case 'G':
				k = 2;
				DNA_counts[k]--;
				
				break;
			case 'T':
				k = 3;
				DNA_counts[k]--;
				
				break;
			}
			switch (input){
			case 'A':
				int k = 0;
				DNA_counts[k]++;
				
				break;
			case 'C':
				k = 1;
				DNA_counts[k]++;
				
				break;
			case 'G':
				k = 2;
				DNA_counts[k]++;				
				break;
			case 'T':
				k = 3;
				DNA_counts[k]++;
				break;
				
			}
			count = 0;
			for (int j = 0; j <4; j++) {
				if (DNA_counts[j] >= condition[j]) {
					count++;
				}
			}
			
			// check
			if (count == 4) {
				answer++;
			}
			
			

		}
		sb.append(answer);
		
		

		/**
		 * 3. 정답 출력
		 */

		System.out.println(sb);
	}
	
	

}
