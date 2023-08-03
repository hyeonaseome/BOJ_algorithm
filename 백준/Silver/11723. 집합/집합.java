import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(in.readLine()); // 수행해야 하는 연산의 수 M

		Set<Integer> S = new HashSet<>();
		for (int i = 0; i < M; i++) {
			String[] split = in.readLine().split(" ");
			int x = split.length == 2 ? Integer.parseInt(split[1]) : 0;
			switch(split[0]) {
			case "add":
				S.add(x);
				break;
			case "remove":
				if (S.contains(x)) {
					S.remove(x);
				}
				break;
			case "check":
				if (S.contains(x)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case "toggle":
				if (S.contains(x)) {
					S.remove(x);
				} else {
					S.add(x);
				}
				break;
			case "all":
				Collections.addAll(S = new HashSet<Integer>(), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,18 ,19, 20);
				break;
			case "empty":
				S = new HashSet<>();
				break;
			}
		}

		

		System.out.println(sb);
	}
}