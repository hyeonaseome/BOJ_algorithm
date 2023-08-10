import java.util.*;
class Solution {
    public class Land {
        int idx;
        int score;
        public Land(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
        
        @Override 
        public String toString() {
            return score + " " + idx;
        }
    }
    public int N, M;
    int solution(int[][] land) {        
        N = land.length;
        M = land[0].length;
        int answer = 0;
        
        for (int i = 1; i < N; i++) {
            List<Land> list = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                list.add(new Land(j, land[i - 1][j]));
            }
            
            Collections.sort(list, new Comparator<Land>() {
                @Override
                public int compare(Land o1, Land o2) {
                    return o2.score - o1.score;
                }
            });

            Land first = list.get(0);
            Land second = list.get(1);
            
            for (int j = 0; j < M; j++) {
                if (first.idx == j) {
                    land[i][j] += second.score;
                    continue;
                }
                land[i][j] += first.score;
            }
        }
        
        for (int i = 0; i < M; i++) {
            answer = Math.max(land[N - 1][i], answer);
        }
        return answer;
    }
}