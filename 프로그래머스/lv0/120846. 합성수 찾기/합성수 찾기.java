import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    set.add(j);
                    set.add( n / j);
                    
                    if (set.size() >= 3) {
                        answer++;
                        break;
                    }
                }

            }
            
        }
        return answer;
    }
}