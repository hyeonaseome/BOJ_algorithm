import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			String T = in.readLine();
			sb.append("#"+ test_case + " ");
			// 1: 사다리, 2: 도착지점
			
			// 100 X 100 2차원 배열
			int[][] map = new int [100][100];
			
			for(int i = 0; i < 100; i++) {
				String[] split = in.readLine().split(" ");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(split[j]);
				}
			}
			
			// 도착지점 위치
			int start_x = 99;
			int start_y = -1;
			for (int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					start_y = i;
				}
			}
			
			
			// 좌, 우, 상
			int[] dx = {0, 0, -1};
			int[] dy = {-1, 1, 0};
			int curx = start_x;
			int cury = start_y;
			
			while ( curx != 0) {
				
				for (int i = 0; i <4; i++) {
					int testx = curx + dx[i];
					int testy = cury + dy[i];
					
					if ((0 <= testx && testx < 100) && 
							(0 <= testy && testy < 100)) {
						if(map[testx][testy] == 1) {
							curx += dx[i];
							cury += dy[i];
							map[testx][testy] = 8;
							break;
						}
					}
				}
				
			}
			sb.append(cury + "\n");		
		}
		System.out.println(sb);
	}
}
