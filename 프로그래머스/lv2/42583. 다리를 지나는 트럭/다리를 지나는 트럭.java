import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new ArrayDeque();
        int truckSum = 0;
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        for (int i = 0; i < truck_weights.length; i++) {
            int cur = truck_weights[i];
            while (truckSum - bridge.peek() + cur > weight) {
                truckSum -= bridge.poll();
                bridge.add(0);
                answer++;
            }
            truckSum += cur - bridge.poll();
            bridge.add(cur);
            answer++;            
        }
        return answer + bridge_length;
    }
}