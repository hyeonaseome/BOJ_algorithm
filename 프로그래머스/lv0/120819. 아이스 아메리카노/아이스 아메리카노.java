class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / 5_500;
        answer[1] = money % 5_500;
        return answer;
    }
}