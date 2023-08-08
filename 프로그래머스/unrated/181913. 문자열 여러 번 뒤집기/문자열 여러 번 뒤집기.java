import java.util.*;
class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] reverse = my_string.toCharArray();
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            
            for (int j = start; j <= start + (end - start)/2; j++) {
                int idx = start + end - j;
                char temp = reverse[j];
                reverse[j] = reverse[idx];
                reverse[idx] = temp;
            } 
        }
        return new String(reverse);
    }
}