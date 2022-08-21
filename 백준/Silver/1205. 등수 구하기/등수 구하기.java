import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int newscore = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> rank = new ArrayList<>();
		if (N > 0) st = new StringTokenizer(in.readLine());
		for (int i = 0; i< N; i++) {
			rank.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(rank, Collections.reverseOrder());
		if ((rank.size() >= P && newscore <= rank.get(P - 1))) {
			sb.append(-1);
		} else {
			rank.add(newscore);
			Collections.sort(rank, Collections.reverseOrder());
			int getrank = rank.indexOf(newscore) + 1;
			sb.append(getrank);
		}
		System.out.println(sb);
	}
}
