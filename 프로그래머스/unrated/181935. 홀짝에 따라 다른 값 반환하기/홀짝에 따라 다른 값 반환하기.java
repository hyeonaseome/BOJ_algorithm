class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if (n % 2 == 1) {
            int m = n/2 + 1;
            answer = m * m;
        } else {
            for (int i = 2; i <= n; i = i + 2) {
                answer += i * i;
            }
        }
        return answer;
    }
}