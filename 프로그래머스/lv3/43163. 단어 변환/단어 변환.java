import java.util.*;

class Solution {
    String[] words;
    String target;
    int N, min;
    boolean[] isSelected;
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        N = words.length;
        min = Integer.MAX_VALUE;
        isSelected = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            if (!isSelected[i] && canChange(begin, words[i]))
                dfs(i, words[i], 1);
        }
        
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }
    
    public void dfs(int num, String cur, int cnt) {
        if (cnt > min)
            return;
        
        if (compare(cur, target) == 0) {
            min = Math.min(cnt, min);
            return;
        }
        isSelected[num] = true;
        
        for (int i = 0; i < N; i++) {
            if (!isSelected[i] && canChange(cur, words[i]))
                dfs(i, words[i], cnt + 1);
        }
    }
    
    public boolean canChange(String str1, String str2) {
        return compare(str1, str2) == 1;
    }
    
    public int compare(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    
}