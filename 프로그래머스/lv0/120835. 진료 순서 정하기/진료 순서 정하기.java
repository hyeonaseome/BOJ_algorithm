import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < emergency.length; i++) {
            map.put(emergency[i], i);
        }
        Arrays.sort(emergency);
        
        for (int i = 1; i <= emergency.length; i++) {
            answer[map.get(emergency[emergency.length - i])] = i;
        }
        
        return answer;
    }
}