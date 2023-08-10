class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
       if (c == m) {
            c = m;
        }
        
        for (int i = 0; i * m + c <= my_string.length(); i++) {
            int idx = i * m + c - 1;
            answer += my_string.charAt(idx);
        }
        return answer;
    }
}