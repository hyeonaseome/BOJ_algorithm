import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine()); // 명령의 수
		Deque<Integer> queue = new ArrayDeque<>();
		String[] split;
		for (int i = 0; i < N; i++) {
			split = in.readLine().split(" ");
			switch(split[0]) {
			case "push":
				queue.offer(Integer.parseInt(split[1]));
				break;
			case "pop":
				if (!queue.isEmpty())
					sb.append(queue.poll());
				else
					sb.append(-1);
				break;
			case "size":
				sb.append(queue.size());
				break;
			case "empty":
				int isEmpty = queue.isEmpty() ? 1: 0;
				sb.append(isEmpty);
				break;
			case "front":
				if (!queue.isEmpty())
					sb.append(queue.peek());
				else
					sb.append(-1);
				break;
			case "back":
				if (!queue.isEmpty())
					sb.append(queue.getLast());
				else
					sb.append(-1);
				break;
			}
			
			if (!split[0].equals("push")) {
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}
}