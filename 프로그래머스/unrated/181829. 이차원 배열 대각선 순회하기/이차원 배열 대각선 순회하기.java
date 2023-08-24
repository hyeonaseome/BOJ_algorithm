class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
            int min = Math.min(board[i].length, k - i + 1);
            for (int j = 0; j < min; j++) {
                answer += board[i][j];
            }
        }
        return answer;
    }
}