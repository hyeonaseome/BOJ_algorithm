import java.util.*;
class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int mode = -1;
        int modeCnt = -1;
        
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            
            if (modeCnt < map.get(num)) {
                mode = num;
                modeCnt = map.get(num);
            } else if (modeCnt == map.get(num)) {
                mode = -1;
            }
        }
        return mode;
    }
}