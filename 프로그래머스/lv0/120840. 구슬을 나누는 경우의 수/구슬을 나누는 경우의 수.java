import java.util.*;

class Solution {
    public int solution(int balls, int share) {
        int[][] comb = new int[balls + 1][balls + 1];
        
        for (int i = 0; i <= balls; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j)
                    comb[i][j] = 1;
                else {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                }
            }
        }

        return comb[balls][share];
    }
}