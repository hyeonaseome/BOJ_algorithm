class Solution {
    public int solution(int n) {
        int mod = 1_000_000_007;
        
        int[] ans = new int[n + 1];
        ans[1] = 1;
        ans[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            ans[i] = (ans[i - 1] % mod + ans[i - 2] % mod) % mod;
        }
        
        return ans[n];
    }
}