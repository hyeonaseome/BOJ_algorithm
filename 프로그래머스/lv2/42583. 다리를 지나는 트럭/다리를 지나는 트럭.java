import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Integer> bridge = new ArrayDeque();
        int truckSum = 0;
        
        for (int i = 0; i < bridge_length - 1; i++) {
            bridge.add(0);
        }
        bridge.add(truck_weights[0]);
        truckSum += truck_weights[0];
        
        for (int i = 1; i < truck_weights.length; i++) {
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