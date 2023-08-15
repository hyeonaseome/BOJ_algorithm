import java.util.*;
class Solution {
    char[] inputs = {'A', 'E', 'I', 'O', 'U'};
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;

        dfs(0, "");
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
    
    public void dfs(int cnt, String cur) {

        if (!cur.equals(""))
            list.add(cur);
        
        if (cnt == 5) {
            return;
        } 
        
        for (int i = 0; i < 5; i++) {
            dfs(cnt + 1, cur + inputs[i]);
        }
    }
}