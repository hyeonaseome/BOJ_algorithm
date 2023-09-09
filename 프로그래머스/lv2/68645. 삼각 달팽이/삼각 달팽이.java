class Solution {
    public int[] solution(int n) {
        int len = n * (n + 1) /2;
        int[] answer = new int[len];
        
        int[][] triagle = new int[n][n];
        int x = 0;
        int y = 0;
        int[] dx = new int[] {1, 0, -1};
        int[] dy = new int[] {0, 1, -1};
        int d = 0;
        
        for (int i = 1; i <= len; i++){
            triagle[x][y] = i;
            
            int testX = x + dx[d];
            int testY = y + dy[d];
            
            if (0 <= testX && testX < n && 0 <= testY && testY < testX + 1 
                && triagle[testX][testY] == 0) {
                x = testX;
                y = testY;
            } else {
                d = (d + 1) % 3;
                x += dx[d];
                y += dy[d];
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < i + 1; j++) {
                answer[idx++] = triagle[i][j];
            }
        }
        
        return answer;
    }
}