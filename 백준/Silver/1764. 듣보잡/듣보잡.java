import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);

		Set<String> unHeard = new TreeSet<>();
		Set<String> neverSeen = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			unHeard.add(in.readLine());
		}

		for (int i = 0; i < M; i++) {
			neverSeen.add(in.readLine());
		}

		unHeard.retainAll(neverSeen);

		sb.append(unHeard.size()).append("\n");

		Iterator<String> iter = unHeard.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next()).append("\n");
		}

		System.out.println(sb);
	}
}