import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String result = "YES";
		
		for (int i = 0; i < N; i++) {
			result = "YES";
			List<String> ps = new ArrayList<>();
			String[] line = br.readLine().split("");
			for ( int j = 0; j < line.length; j++) {
				if (line[j].equals("(")) {
					ps.add(line[j]);
				}else {
					if(ps.size() < 1) {
						result = "NO";
						break;
					}
					if(ps.get(ps.size() - 1).equals("(")) {
						ps.remove(ps.size() - 1);
					}else {
						result = "NO";
						break;
					}
				}
			}
			if (ps.size() != 0) {
				result = "NO";
			}
			System.out.println(result);
			
		}
	}

}
