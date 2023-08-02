class Solution {
    private boolean[] isSelected;
    public int solution(int n, int[][] computers) {isSelected = new boolean[n];
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!isSelected[i]){
                dfs(i, n, computers);
                cnt++;
            }
        }
        return cnt;
    }
    
    private void dfs(int computerIdx, int n, int[][] computers) {
        isSelected[computerIdx] = true;
        
         for (int i = 0; i < n; i++) {
            if (!isSelected[i] && computers[computerIdx][i] == 1){
                dfs(i, n, computers);
            }
        }
    }
}