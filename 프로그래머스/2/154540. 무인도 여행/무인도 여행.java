import java.util.*;

class Solution {
    public int N, M;
    public boolean [][] isVisited;
    public Map<Integer, Integer> counter;
    
    // 상, 우, 하, 좌
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        int[] answer = { -1 };
        
        N = maps.length;
        M = maps[0].length();
        isVisited = new boolean[N][M];
        counter = new HashMap<>();
        
        int cntSeom = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i].charAt(j) != 'X' && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    counter.put(cntSeom, maps[i].charAt(j) - '0');
                    dfs(i, j, maps, cntSeom++);
                }
            }
        }
        
        
        List<Integer> list = new ArrayList<>(counter.values());
        Collections.sort(list);
        
        if (!counter.isEmpty()) {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        
        return answer;
    }
    
    public void dfs(int x, int y, String[] maps, int cntSeom) {
        
        for (int d = 0; d < 4; d++) {
            int testX = x + dx[d];
            int testY = y + dy[d];
            if (!(0 <= testX && testX < N && 0 <= testY && testY < M)) continue;
            if (maps[testX].charAt(testY) != 'X' && !isVisited[testX][testY]) {
                isVisited[testX][testY] = true;
                counter.put(cntSeom, counter.get(cntSeom) + maps[testX].charAt(testY) - '0');
                dfs(testX, testY, maps, cntSeom);
            }
        }
        
    }
    
}