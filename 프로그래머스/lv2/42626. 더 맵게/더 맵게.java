import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K) {
            if (pq.size() == 1) {
                answer = -1;
                break;
            }
            answer++;
            
            int scoville1 = pq.poll();
            int scoville2 = pq.poll();
            pq.add(scoville1 + scoville2 * 2);
        }
        return answer;
    }
}