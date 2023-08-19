import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = { -1 };
        
        int i = 0;
        Stack<Integer> stk = new Stack<>();
        while(i < arr.length) {
            if (!stk.isEmpty() && stk.peek() == arr[i]) {
                stk.pop();
            } else {
                stk.push(arr[i]);
            }
            i++;
        }
        
        if (!stk.isEmpty()) {
            answer = stk.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return answer;
    }
}