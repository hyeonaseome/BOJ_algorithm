class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];

        for (int i = start, cnt = 0; i >= end; i--) {
            answer[cnt++] = i;
        }
        return answer;
    }
}