class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        
        String numStr = num + "";
        
        for (int i = 0; i < numStr.length(); i++) {
            if (Integer.parseInt(numStr.charAt(i) + "") == k) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}