import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        
        Arrays.fill(answer, -1);
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0, cnt = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                answer[cnt++] = arr[i];
                set.add(arr[i]);
            }
            
            if (cnt == k) {
                break;
            }
        }
        return answer;
    }
}