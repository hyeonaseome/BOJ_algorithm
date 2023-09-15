class Solution {
    public int solution(int order) {
        int answer = 0;
        String orderNum = Integer.toString(order);
        for (char ch : orderNum.toCharArray()) {
            if (ch == '3' || ch == '6' || ch == '9') {
                answer++;
            }
        }
        return answer;
    }
}