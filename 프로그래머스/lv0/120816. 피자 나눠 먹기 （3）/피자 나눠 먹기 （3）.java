class Solution {
    public int solution(int slice, int n) {
        int answer = 1;
        
        while(true) {
            if (slice * answer / n >= 1) {
                break;
            }
            answer++;
        }
        return answer;
    }
}