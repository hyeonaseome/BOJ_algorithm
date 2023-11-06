class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        
        int W = board[0] / 2;
        int H = board[1] / 2;
        
        for (String key : keyinput) {
            int testX = answer[0];
            int testY = answer[1];
            if (key.equals("up")) {
                testY += 1;
            } else if (key.equals("down")) {
                testY -= 1;
            } else if (key.equals("left")) {
                testX -= 1;
            } else if (key.equals("right")) {
                testX += 1;
            }
            
            if (!(-1 * W <= testX && testX <= W && -1 * H <= testY && testY <= H)) continue;
            
            answer[0] = testX;
            answer[1] = testY;
        }
        return answer;
    }
}