/*
최소 필요 피로도: 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
소모 피로도: 던전을 탐험한 후 소모되는 피로도
*/
import java.util.Arrays;
class Solution {
    
    public int N, maxDungeon;
    public boolean[] isSelected;
    
    public int solution(int k, int[][] dungeons) {  
        N = dungeons.length;
        maxDungeon = 0;
        isSelected = new boolean[N];
        
        dfs(0, k, dungeons);
        return maxDungeon;
    }
    
    public void dfs(int cnt, int k, int[][] dungeons) {
        if(cnt == N) {
            maxDungeon = N;
            return;
        }
        
        if (maxDungeon == N){
            return;
        }
        
        for (int i = 0; i < N; i++) {
            
            if (isSelected[i]) continue;
            
            if (k >= dungeons[i][0]) {
                isSelected[i] = true;
                dfs(cnt + 1, k - dungeons[i][1], dungeons);   
                isSelected[i] = false;
            }
            else {
                maxDungeon = Math.max(maxDungeon, cnt);
            }
            
        }
    }
}
