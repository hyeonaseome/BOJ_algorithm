class Solution {
    public int solution(String[] order) {
        int answer = 0;
    
        for (String ord : order) {
            if (ord.contains("americano") || ord.equals("anything")) {
                answer += 4500;
            } else {
                answer += 5000;
            }
        }
        return answer;
    }
}