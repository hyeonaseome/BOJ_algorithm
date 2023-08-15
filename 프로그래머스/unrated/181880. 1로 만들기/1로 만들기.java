class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            answer += Integer.toBinaryString(num).length() - 1;
        }
        return answer;
    }
}