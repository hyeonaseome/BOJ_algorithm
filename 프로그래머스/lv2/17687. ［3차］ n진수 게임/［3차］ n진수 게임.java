class Solution {
    public String solution(int n, int t, int m, int p) {

        String answer = "";
        String numbers = "";
        
        for (int i = 0; i < m * t; i++) {
            numbers += Integer.toString(i, n);
            if (numbers.length() > m * t) {
                break;
            }
        }
        
        for (int i = 0; i < t; i++) {
            answer += numbers.charAt(m * i + p - 1);
        }
        return answer.toUpperCase();
    }
}