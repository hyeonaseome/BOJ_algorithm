class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        
        for (int i = 0; i < num_list.length; i++) {
            answer[i] = num_list[i];
        }
        
        int lastValue = num_list[num_list.length - 1];
        int minus = lastValue - num_list[num_list.length - 2];
        answer[answer.length - 1] = minus > 0 ? minus : lastValue * 2;
        return answer;
    }
}