class Solution {
    public String solution(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            counts[ch - 'a']++;
        }
        
        String answer = "";
        for (int i = 0; i < 26; i++) {
            if (counts[i] == 1) {
                answer += (char) (i + 'a');
            }
        }
        return answer;
    }
}