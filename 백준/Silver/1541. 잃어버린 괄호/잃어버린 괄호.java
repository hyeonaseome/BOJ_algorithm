import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = in.readLine();
		List<String> list = new ArrayList<String>();
		int index = 0;
		for (int i = 0, size = line.length(); i < size; i++) {
			if (line.charAt(i) == '+') {
				String split = line.substring(index, i);
				list.add(split);
				list.add("+");
				index = i+1;
			}
			else if (line.charAt(i) == '-') {
				String split = line.substring(index, i);
				list.add(split);
				list.add("-");
				
				index = i+1;
			}
		}
		list.add(line.substring(index, line.length()));

		while (list.contains("+")) {
			int plusIdx = list.indexOf("+");
			int answer = Integer.parseInt(list.get(plusIdx-1)) +  Integer.parseInt(list.get(plusIdx +1));
			list.remove(plusIdx- 1);
			list.remove(plusIdx- 1);
			list.remove(plusIdx- 1);
			list.add(plusIdx- 1, String.valueOf(answer));
		}
		while (list.contains("-")) {
			int plusIdx = list.indexOf("-");
			int answer = Integer.parseInt(list.get(plusIdx-1)) -  Integer.parseInt(list.get(plusIdx +1));
			list.remove(plusIdx- 1);
			list.remove(plusIdx- 1);
			list.remove(plusIdx- 1);
			list.add(plusIdx- 1, String.valueOf(answer));
		}

		sb.append(list.get(0));
		System.out.println(sb);
		
	}
}
