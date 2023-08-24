class Solution {
    public String solution(String myString) {
        String answer = "";
        for (char ch : myString.toCharArray()) {
            answer += ch - 'l' < 0 ? "l" : ch;
        }
        return answer;
    }
}