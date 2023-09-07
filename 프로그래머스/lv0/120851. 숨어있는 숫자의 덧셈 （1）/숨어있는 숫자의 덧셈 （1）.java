class Solution {
    public int solution(String my_string) {
        String my_string_num = my_string.replaceAll("[^0-9]", ""); 
        int answer = 0;
        for (int i = 0; i < my_string_num.length(); i++) {
            answer += my_string_num.charAt(i) - '0';
        }
        return answer;
    }
}