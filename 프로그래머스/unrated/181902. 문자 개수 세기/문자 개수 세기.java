import java.util.*;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];

        for (char ch : my_string.toCharArray()) {
            if (ch >= 'a') {
                answer[ch - 'a' + 26] += 1;
            } else {
                answer[ch - 'A'] += 1;
            }
        }
        return answer;
    }
}