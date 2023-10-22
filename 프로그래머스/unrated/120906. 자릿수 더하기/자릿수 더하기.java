class Solution {
    public int solution(int n) {
        int answer = 0;
        String nStr = n + "";
        
        for (int i = 0; i < nStr.length(); i++) {
            answer += nStr.charAt(i) - '0';
        }
        
        return answer;
    }
}