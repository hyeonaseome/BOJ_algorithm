import java.util.*;

class Solution {
    boolean[][] check;
    boolean[] isSelected;
    int[] numbers;
    int userIdLen, banIdLen;
    
    Set<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replaceAll("\\*", ".");
        }
        
        userIdLen = user_id.length;
        banIdLen = banned_id.length;
        check = new boolean[banIdLen][userIdLen];
        
        for (int i = 0; i < banIdLen; i++) {
            for (int j = 0; j < userIdLen; j++) {
                if (user_id[j].matches(banned_id[i])) {
                    check[i][j] = true;
                }
            }
        }
        
        isSelected = new boolean[userIdLen];
        numbers = new int[banIdLen];
        
        dfs(0);
        
        return set.size();
    }
    
    
    public void dfs(int cnt) {
        if (cnt == banIdLen) {
            int[] numCopy = Arrays.copyOf(numbers, banIdLen);
            Arrays.sort(numCopy);
            set.add(Arrays.toString(numCopy));
            return;
        }
        
        for (int i = 0; i < userIdLen; i++) {
            if (isSelected[i]) continue;
            
            if (check[cnt][i]) {
                isSelected[i] = true;
                numbers[cnt] = i + 1;
                dfs(cnt + 1);
                isSelected[i] = false;
            }
        }
    }
}