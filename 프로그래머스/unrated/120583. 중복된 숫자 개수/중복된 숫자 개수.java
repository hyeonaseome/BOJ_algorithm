import java.util.*;

class Solution {
    public int solution(int[] array, int n) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.getOrDefault(n, 0);
    }
}