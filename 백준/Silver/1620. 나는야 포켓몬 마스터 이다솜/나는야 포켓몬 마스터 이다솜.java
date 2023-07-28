import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] split = in.readLine().split(" ");
		int N = Integer.parseInt(split[0]); // 도감에 수록되어 있는 포켓몬의 개수 
		int M = Integer.parseInt(split[1]); // 내가 맞춰야하는 문제의 개수
		
		HashMap<String, String> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String poketmon = in.readLine();
			map.put(i + "", poketmon);
			map.put(poketmon, i + "");
		}
		
		for (int i = 0; i < M; i++) {
			sb.append(map.get(in.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}