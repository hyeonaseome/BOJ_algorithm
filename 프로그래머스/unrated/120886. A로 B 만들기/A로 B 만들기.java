import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        char[] beforeArr = before.toCharArray();
        Arrays.sort(beforeArr);
        String resultBefore = new String(beforeArr);
        
        char[] afterArr = after.toCharArray();
        Arrays.sort(afterArr);
        String resultAfter = new String(afterArr);
        
        answer = resultBefore.equals(resultAfter) ? 1 : 0;

        return answer;
    }
}