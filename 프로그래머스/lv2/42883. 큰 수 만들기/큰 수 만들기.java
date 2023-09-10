import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            int curNum = Integer.parseInt(number.charAt(i) + "");
            while (stack.size() > 0 && stack.peek() < curNum && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(curNum);
        }
        
        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        
        if (k > 0) {
            answer = answer.substring(0, number.length() - k);
        }
        
        return answer;
    }
}