import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> costs = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            String[] HHmm = split[0].split(":");
            
            int hour = Integer.parseInt(HHmm[0]);
            int mins = Integer.parseInt(HHmm[1]);
            int toMins = hour * 60 + mins;
            
            String carNumber = split[1];
            String inOut = split[2];
            
            if (inOut.equals("IN")) {
                parking.put(carNumber, toMins);
            } else {
                int startMins = parking.get(carNumber);
                int parkingMins = toMins - startMins;
                costs.put(carNumber, costs.getOrDefault(carNumber, 0) + parkingMins);
                parking.remove(carNumber);
            }
        }
        
        List<String> parkingKeySet = new ArrayList<>(parking.keySet());
        for (String carNumber : parkingKeySet) {
            int startMins = parking.get(carNumber);
            int toMins = 23 * 60 + 59;
            int parkingMins = toMins - startMins;
            costs.put(carNumber, costs.getOrDefault(carNumber, 0) + parkingMins);
            parking.remove(carNumber);
        }
        
        List<String> costsKeySet = new ArrayList<>(costs.keySet());
        Collections.sort(costsKeySet);
        
        int[] answer = new int[costsKeySet.size()];
        int idx = 0;
        for (String carNumber : costsKeySet) {
            int cost = fees[1];
            float totalMins = costs.get(carNumber) - fees[0] * 1.0f;
            if (totalMins > 0) {
                cost += Math.ceil( totalMins / fees[2]) * fees[3];
            }
            answer[idx++] = cost;
        }

        return answer;
    }
}