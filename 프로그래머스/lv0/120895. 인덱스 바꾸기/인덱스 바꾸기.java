class Solution {
    public String solution(String my_string, int num1, int num2) {
        num1 = Math.min(num1, num2);
        num2 = Math.max(num1, num2);
        
        String answer = my_string.substring(0, num1) + my_string.charAt(num2);
        answer += my_string.substring(num1 + 1, num2) + my_string.charAt(num1) + my_string.substring(num2 + 1);
        return answer;
    }
}