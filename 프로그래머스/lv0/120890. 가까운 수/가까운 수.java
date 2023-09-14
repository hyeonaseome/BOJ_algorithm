import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        Integer array2[] = Arrays.stream(array).boxed().toArray(Integer[]::new); 
        
        Arrays.sort(array2, new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               if (Math.abs(n - o1) != Math.abs(n - o2)) {
                   return Math.abs(n - o1) - Math.abs(n - o2); // (n - o1) - (n - o2)
               }
               return o1 - o2;
           }
        });
        
        return array2[0];
    }
}