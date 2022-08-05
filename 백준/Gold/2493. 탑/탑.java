import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		Stack<Tower> stack = new Stack<>();

		int N = Integer.parseInt(in.readLine());
		int[] answer = new int[N +1 ];
		int[] tops = Arrays.stream(("0 " +in.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 1; i <= N; i++) {

			Tower cur_tower = new Tower (i, tops[i]);
			if (stack.isEmpty()) {
				stack.push(cur_tower);

			}
			else {
				while (!stack.isEmpty()) {
					Tower peek = stack.peek();
					if (cur_tower.height > peek.height) {
						stack.pop();
					}else {
						answer[cur_tower.no] = peek.no;
						break;
					}
				}
				

				stack.push(cur_tower);
			}
		}

		for(int i = 1; i < N+1; i++) {
			sb.append(answer[i] + " ");
		}


		System.out.println(sb);
	}
}

class Tower{
	int no;
	int height;

	public Tower(int no, int height) {
		this.no = no;
		this.height = height;
	}
}