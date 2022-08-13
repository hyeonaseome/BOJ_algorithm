import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int X = Integer.parseInt(split[0]);
		int Y = Integer.parseInt(split[1]);

		sb.append(Rev(Rev(X) + Rev(Y)));
		System.out.println(sb);
	}

	private static int Rev(int x) {
		Stack<String> stack = new Stack<>();
		String newx =  Integer.toString(x);
		for (int i = 0; i < newx.length(); i++) {
			stack.push(Character.toString(newx.charAt(i)));
		}
		String s = "";
		for (int i = 0; i < newx.length(); i++) {
			s += stack.pop();
		}
		return Integer.parseInt(s);
	}
}
