import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int s = queries[j][0];
            int e = queries[j][1];
            int k = queries[j][2];
            boolean isExist = false;
            for (int i = s; i <= e; i++) {
                if (k < arr[i]) {
                    if (!isExist)
                        answer[j] = arr[i];
                    else {
                        answer[j] = Math.min(arr[i], answer[j]);
                    }
                    isExist = true;
                }
            }
            if (!isExist) {
                answer[j] = -1;
            }
        }
        return answer;
    }
}