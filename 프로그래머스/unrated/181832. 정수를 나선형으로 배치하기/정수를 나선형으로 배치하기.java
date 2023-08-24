class Solution {
    
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int x = 0; 
        int y = 0;
        int j = 0;
        int i = 1;
        answer[x][y] = i++;
        
        while(n * n >= i) {
            while(true) {
                int testX = x + dx[j];
                int testY = y + dy[j];
                if (!(0 <= testX && testX < n && 0 <= testY && testY < n)) break;
                if (answer[testX][testY] != 0) {
                    break;
                } else {
                    answer[testX][testY] = i++;
                    x = testX;
                    y = testY;
                }
                
            }
            j = (j + 1) % 4;
        }
        return answer;
    }
}