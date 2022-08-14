import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 결과를 한 번에 출력하기 위한 StringBuilder
		StringBuilder sb = new StringBuilder();

		/**
		 * 1. 입력 파일 객체화
		 */
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			// 지원자의 수
			int N = Integer.parseInt(st.nextToken());
			PriorityQueue<interviewee> rank2 = new PriorityQueue<>( new Comparator<interviewee>() {
				@Override
				public int compare(interviewee o1, interviewee o2) {
					return o1.doc - o2.doc;
				}
			});
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int doc = Integer.parseInt(st.nextToken());
				int inter = Integer.parseInt(st.nextToken());
				interviewee a = new interviewee(doc, inter);
				rank2.add(a);
			}
			
			/**
			 * 2. 알고리즘 풀기
			 */
			int count = 0;
			int largeinter = rank2.peek().inter;
			for (int i = 0; i < N; i++) {
				if (rank2.peek().inter <= largeinter) {
					count++;
					largeinter = rank2.peek().inter;
				}
				rank2.poll();
			}
			

			/**
			 * 3. 정답 출력
			 */
			sb.append(count + "\n");
		}

		System.out.println(sb);
	}
}
class interviewee{
	public int doc;
	public int inter;
	public interviewee(int doc, int inter) {
		this.doc = doc;
		this.inter = inter;
	}
	@Override
	public String toString() {
	return "["+doc+", "+ inter+"]";
	}
}