import java.util.*;
class Solution {
    public int solution(int a, int b, int c) {
        Set<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        
        int answer = 1;
        switch(set.size()) {
            case 1:
                answer *= Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3);
            case 2:
                answer *= Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2);
            case 3:
                answer *= a + b + c;
        }
        
        return answer;
    }
}