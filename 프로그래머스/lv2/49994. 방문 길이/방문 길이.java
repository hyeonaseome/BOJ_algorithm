import java.util.*;

class Solution {
    public static boolean[][][] board;
    public static final int[] dx = {-1, 0, 0, 1};
    public static final int[] dy = {0, 1, -1, 0};
    
    public int solution(String dirs) {
        board = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0);
        map.put('R', 1);
        map.put('L', 2);
        map.put('D', 3);
        
        for (int i = 0; i < dirs.length(); i++) {

            int d = map.get(dirs.charAt(i));
            
            int testX = x + dx[d];
            int testY = y + dy[d];
            if (!isPossible(testX, testY)) continue;
            
            if (!board[x][y][d]) {
                answer++;
            }
            
            board[x][y][d] = true;
            board[testX][testY][3 - d] = true;
            
            x = testX;
            y = testY;
        }
        return answer;
    }
    public boolean isPossible(int x, int y) {
        return 0 <= x && x < 11 && 0 <= y && y < 11;
    }
}