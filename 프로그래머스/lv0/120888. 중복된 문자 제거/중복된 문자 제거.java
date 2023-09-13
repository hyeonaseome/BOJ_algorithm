import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            String cur = my_string.substring(i, i+1);
            if (!set.contains(cur)) {
                set.add(cur);
                answer += cur;
            }
        }
        return answer;
    }
}