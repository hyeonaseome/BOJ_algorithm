class Solution {
    public String[] solution(String[] names) {
        String[] answer = new String[(names.length - 1) / 5 + 1];
        
        for (int i = 0, cnt = 0; i < names.length; i += 5) {
            answer[cnt++] = names[i];
        }
        
        return answer;
    }
}