import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int kingC = split[0].charAt(0) - 'A';
		int kingR = 8 - (split[0].charAt(1) - '0');
		int rockC = split[1].charAt(0) - 'A';
		int rockR = 8 - (split[1].charAt(1) - '0');
		int N = Integer.parseInt(split[2]);
		
		// 우, 좌, 하, 상, 우상, 좌상, 우하, 좌하
		int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
		int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

		for (int i = 0; i < N; i++) {
			String com = in.readLine();
			int num = 0;
			switch(com) {
			case "R":
				num = 0;
				break;
			case "L":
				num = 1;
				break;
			case "B":
				num = 2;
				break;
			case "T":
				num = 3;
				break;
			case "RT":
				num = 4;
				break;
			case "LT":
				num = 5;
				break;
			case "RB":
				num = 6;
				break;
			case "LB":
				num = 7;
				break;
			}
			
			int kr = kingR + dr[num];
			int kc = kingC + dc[num];
			int rr = rockR + dr[num];
			int rc = rockC + dc[num];
			if(0 <= kr && kr < 8 && 0 <= kc && kc < 8) {
				if (kr == rockR && kc == rockC) {
					if (0 <= rr && rr < 8 && 0 <= rc && rc < 8) {
						kingR = kr;
						kingC = kc;
						rockR = rr;
						rockC = rc;
					}
				}else {
					kingR = kr;
					kingC = kc;
				}
			}
		}

		sb.append((char)(kingC + 'A')).append(8 - kingR).append("\n");
		sb.append((char)(rockC + 'A')).append(8 - rockR);
		System.out.println(sb);
	}
}
