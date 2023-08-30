class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            String cur = my_string.substring(i, i+1);
            if (!cur.equals(letter)) {
                answer += cur;
            }
        }
        return answer;
    }
}