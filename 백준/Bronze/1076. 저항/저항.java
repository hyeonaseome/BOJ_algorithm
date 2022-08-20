import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String color1 = in.readLine();
		String color2 = in.readLine();
		String color3 = in.readLine();
		
		HashMap<String, Integer> color = new HashMap<>();
		color.put("black", 0);
		color.put("brown", 1);
		color.put("red", 2);
		color.put("orange", 3);
		color.put("yellow", 4);
		color.put("green", 5);
		color.put("blue", 6);
		color.put("violet", 7);
		color.put("grey", 8);
		color.put("white", 9);
		
		long[] mul = new long [10];
		mul[0] = 1l;
		for (int i = 1; i < 10; i++) {
			mul[i] = mul[i -1] * 10;
		}
		
		long answer = (color.get(color1)*10 + color.get(color2)) * mul[color.get(color3)];	
		sb.append(answer);
		System.out.println(sb);
	}
}
