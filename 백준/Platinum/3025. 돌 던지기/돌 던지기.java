import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	private static char stone = 'O';
	private static char space = '.';
	private static char wall = 'X';
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] split = in.readLine().split(" ");
		int R = Integer.parseInt(split[0]);
		int C = Integer.parseInt(split[1]);
		
		char[][] map = new char[R][C];
		for (int i = 0; i< R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		rows[] ttrow = new rows[C];
		for (int i = 0; i< C; i++) {
			ttrow[i] = new rows();
			ttrow[i].routes.add(new loc(0, i));
		}
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i< N; i++) {
			int row = Integer.parseInt(in.readLine()) - 1;
			int stoneR = 0;
			int stoneC = 0;
			while(true) {
				stoneR = ttrow[row].routes.peek().r;
				stoneC = ttrow[row].routes.peek().c;
				if(map[stoneR][stoneC] == space) {
					break;
				}else {
					ttrow[row].routes.pop();
				}
			}
			
			while(true) {
				if(stoneR == R - 1 || map[stoneR + 1][stoneC] == wall) {
					map[stoneR][stoneC] = stone;
					break;
				}
				else if(map[stoneR + 1][stoneC] == space) {
					stoneR = stoneR + 1;
					ttrow[row].routes.add(new loc(stoneR, stoneC));
				}
				else if (map[stoneR + 1][stoneC] == stone) {
					if(0<=stoneC - 1 && map[stoneR][stoneC - 1] == space && map[stoneR + 1][stoneC - 1] == space) {
						stoneC = stoneC - 1;
					}else if (stoneC + 1 < C && map[stoneR][stoneC + 1] == space && map[stoneR + 1][stoneC + 1] == space) {
						stoneC = stoneC + 1;
					}else {
						map[stoneR][stoneC] = stone;
						break;
					}
				}
			}

		}
		for (int i = 0; i< R; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}

		System.out.println(sb);
	}
	static class loc{
		int r;
		int c;
		public loc(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static class rows{
		Stack<loc> routes = new Stack<>();		
	}
}
