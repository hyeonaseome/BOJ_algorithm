import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int num = 0;
	static int R, C;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cut2(0, 0, 1<<N);

		System.out.println(sb);
	}

	private static void cut2(int r, int c, int size) {
		if (size == 1) {
			if (r == R && c == C) {
				sb.append(num);
				return;
			}
			num++;
		}
		else {
			int half = size / 2;
			if (r <= R && R < r + half &&
					c <= C && C < c + half) {
				cut2(r, c, half); 		 	 // 좌상
			}
			else if (r <= R && R < r + half &&
					c + half <= C && C < c + 2 * half){
				num += half * half;
				cut2(r, c+half, half); 		 // 우상
				
			}
			else if (r + half <= R && R < r + 2 * half &&
					c <= C && C < c + half){
				num += half * half * 2;
				cut2(r + half, c, half); 	 // 좌하
				
			}
			else if (r + half <= R && R < r + 2 * half &&
					c + half <= C && C < c + 2 * half){
				num += half * half * 3;
				cut2(r + half, c+half, half); // 우하
				
			}
		}
		
	}
}
