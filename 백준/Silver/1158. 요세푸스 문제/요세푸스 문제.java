import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split  = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int K = Integer.parseInt(split[1]);
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for (int i= 1; i <= N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		int count = 1;
		while(queue.size() > 1) {
			if (count % K == 0) {
				sb.append(queue.peek() +", ");
				queue.poll();
			} else {
				queue.offer(queue.peek());
				queue.poll();
			}
			count++;
		}
		
		sb.append(queue.peek() + ">");
		System.out.println(sb);
	}
}
