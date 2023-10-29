class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        
        for (int friend : array) {
            if (friend > height) {
                answer++;
            }
        }
        return answer;
    }
}