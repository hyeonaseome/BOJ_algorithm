class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;
        
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                if (map[x][y]  == -1) continue;
                if ( y >= 1 && map[x][y - 1] != -1) map[x][y] += map[x][y - 1] % 1_000_000_007;
                if ( x >= 1 && map[x - 1][y] != -1) map[x][y] += map[x - 1][y] % 1_000_000_007;
                map[x][y] %= 1_000_000_007;
            }
        }
        
        return map[n-1][m-1] % 1_000_000_007;
    }
}