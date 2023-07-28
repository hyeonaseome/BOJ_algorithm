import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine()); // 수의 개수

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(in.readLine()));
		}

		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}

		System.out.println(sb);
	}
}