import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int limit = -30_001;
        for (int[] route : routes) {
            if (route[0] > limit) {
                limit = route[1];
                answer++;
            }
        }

        return answer;
    }
}