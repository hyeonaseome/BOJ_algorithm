import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set1 = new HashSet<>(Arrays.asList(s1));
        
        for (String word : s2) {
            if (set1.contains(word)) {
                answer++;
            }
        }
        return answer;
    }
}