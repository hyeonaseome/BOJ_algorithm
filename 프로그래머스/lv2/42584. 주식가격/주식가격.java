import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            
            // 다음값이 작음
            while(!stack.empty() && prices[i] < prices[stack.peek()]) {
                int last = stack.pop();
                answer[last] = i - last;
            }
            stack.push(i);
        }
        
         while(!stack.empty()) {
                int last = stack.pop();
                answer[last] = prices.length - 1 - last;
        }
        return answer;
    }
}