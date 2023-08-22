import java.util.*;
class Solution {
    
    public static int[] dx = {0, 1, 1};
    public static int[] dy = {1, 1, 0};
    
    public int m, n;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        this.m = m;
        this.n = n;
        
        char[][] kakaoBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            kakaoBoard[i] = board[i].toCharArray();
        }
        
        int cnt = 1;
        while (cnt != 0) {
            cnt = friendsBlock(kakaoBoard);
            answer += cnt;
        }
        
        
        return answer;
    }
    
    public int friendsBlock(char[][] board) {
        int answer = 0;
        boolean[][] deleted = new boolean[m][n];
        
        // 카카오 프렌즈 블록 4개씩 붙어 있는 경우 삭제
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                boolean flag = true;
                char cur = board[i][j];
                if (cur == ' ') continue;
                
                for (int k = 0; k < 3; k++) {
                    int newi = i + dx[k];
                    int newj = j + dy[k];
                    if (cur != board[newi][newj]) {
                        flag = false;
                        break;
                    }
                }
                
                if (flag) {
                    deleted[i][j] = true;
                    for (int k = 0; k < 3; k++) {
                        int newi = i + dx[k];
                        int newj = j + dy[k];
                        deleted[newi][newj] = true;
                    }
                }
            }
        }
        
        int[][] drop = new int[m][n];
        // 블록 빈공간 채우기
        dropBlock(drop, deleted, board);
        
        // 점수 계산
        return getScore(drop);
    }
    
    public void dropBlock(int[][] drop, boolean[][] deleted, char[][] board) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                int bef = i < m - 1 ? drop[i+1][j] : 0;
                int aft = deleted[i][j] ? 1 : 0;
                drop[i][j] = bef + aft;
                
                if (!deleted[i][j] && drop[i][j] > 0) {
                    board[i + drop[i][j]][j] = board[i][j];
                    board[i][j] = ' ';
                } else if (deleted[i][j]) {
                    board[i][j] = ' ';
                }
            }
        }
    }
    
    public int getScore(int[][] drop) {
        int score = 0;
        for (int j = 0; j < n; j++) {
            score += drop[0][j];
        }
        return score;
    }
}