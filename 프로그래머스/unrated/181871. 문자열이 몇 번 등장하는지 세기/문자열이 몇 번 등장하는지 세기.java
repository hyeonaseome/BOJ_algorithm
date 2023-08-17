class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int findIndex = myString.indexOf(pat);
  
        while (findIndex >= 0) {
            answer++;
            findIndex = myString.indexOf(pat, findIndex + 1);
        }
        return answer;
    }
}