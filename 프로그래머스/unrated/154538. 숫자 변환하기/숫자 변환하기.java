import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        int[] cnt = new int[1_000_001];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        
        while(!queue.isEmpty()) {
            int size = queue.size();

            while( --size >= 0) {
                int cur = queue.poll();
                if (cur == y) {
                    return cnt[y];
                }
                
                int[] temp = new int[3];
                temp[0] = cur + n;
                temp[1] = cur * 2;
                temp[2] = cur * 3;
            
                for (int t : temp) {
                    if (t <= y && cnt[t] == 0) {
                        queue.offer(t);
                        cnt[t] = cnt[cur] + 1;
                    }
                }
                
            }
        }
        return answer;
    }
}