class Solution {
    public String[] solution(String my_str, int n) {
        int len = (my_str.length() - 1) / n + 1;
        String[] answer = new String[len];
        
        for (int i = 0; i < len; i++) {
            int end = Math.min(my_str.length(), n * (i + 1));
            answer[i] = my_str.substring( n*i,  end);
        }
        
        return answer;
    }
}