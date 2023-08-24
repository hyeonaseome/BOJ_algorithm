class Solution {
    public String[] solution(String[] picture, int k) {
        int n = picture.length * k;
        int m = picture[0].length() *k;
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < m; j++) {
                answer[i] += picture[i / k].charAt(j / k);
            }
        }
        return answer;
    }
}