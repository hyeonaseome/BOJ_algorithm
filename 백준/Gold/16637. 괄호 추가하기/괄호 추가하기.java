import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static boolean[] braket;
	static boolean[] isSelected;
	static int R, max;
	static int[] numbers;
	static String line;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		isSelected = new boolean[N+1];
		
		// 짝수: 숫자, 홀수: 연산자
		line = in.readLine();
		
		max = Integer.MIN_VALUE;
		
		int size = (N + 1) /4;
		for (int i = 1; i <= size; i++) {
			R = 2 * i;
			numbers = new int [R];
			comb(0, 0);
		}

		if (max == Integer.MIN_VALUE) {
			max = line.charAt(0) - '0';
		}
		sb.append(max);

		System.out.println(sb);
	}
	private static void comb(int cnt, int start) {
		if(cnt == R) {
			Queue<String> queue = new ArrayDeque<String>();
			int index = 0;
			int numbersIdx = 0;
			// 괄호 안 먼저 계산
			while(index < line.length()) {
				if (numbersIdx <numbers.length && numbers[numbersIdx] == index) {
					int s = numbers[numbersIdx];
					int e = numbers[numbersIdx + 1];
					int answer = line.charAt(s) - '0';
					for (int j = s + 1; j < e; j =  j + 2) {
						switch(line.charAt(j)) {
						case '+':
							answer += line.charAt(j + 1) - '0';
							break;
						case '-':
							answer -= line.charAt(j + 1) - '0';
							break;
						case '*':
							answer *= line.charAt(j + 1) - '0';
							break;
						}
					}
					numbersIdx += 2;
					index = e;
					queue.offer(String.valueOf(answer));
				}
				else { // 괄호 아닌 연산 queue에 담기
					queue.offer(Character. toString(line.charAt(index)));
					index++;
				}
			}
			
			int result = Integer.parseInt(queue.poll());
			while(!queue.isEmpty()) {
				switch(queue.poll()) {
				case "+":
					result += Integer.parseInt(queue.poll());
					break;
				case "-":
					result -= Integer.parseInt(queue.poll());
					break;
				case "*":
					result *= Integer.parseInt(queue.poll());
					break;
				}
			}
			
			if (max < result) {
				max = result;
			}
			
			return;
		}
		// 유도부분
		if (cnt % 2 == 0) {
			for(int i = start; i < isSelected.length - 2; i = i + 2) {
				numbers[cnt] = i;
				comb(cnt+1, i+3);
			}
		}else {
			numbers[cnt] = start;
			comb(cnt+1, start+1);
		}
	}
}
