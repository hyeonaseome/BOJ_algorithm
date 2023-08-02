import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int answer = bfs(maps);
        return answer;
    }

    private static int bfs(int[][] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] isVisited = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0, 0});
        isVisited[0][0] = true;


        while (!queue.isEmpty()) {
            answer++;
            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                if (x == N - 1 && y == M - 1) {
                    return answer;
                }

                for (int i = 0; i < 4; i++) {
                    int testX = x + dx[i];
                    int testY = y + dy[i];

                    if (!(0 <= testX && testX < N && 0 <= testY && testY < M))
                        continue;

                    if (maps[testX][testY] == 1 && !isVisited[testX][testY]) {
                        isVisited[testX][testY] = true;
                        queue.offer(new int[] {testX, testY});
                    }
                }
            }

        }
        return -1;
    }
}