import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>(); 
        for (int e : arr) {
            list.add(e);
        }
        
        for (int e : delete_list) {
            list.remove(Integer.valueOf(e));
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}