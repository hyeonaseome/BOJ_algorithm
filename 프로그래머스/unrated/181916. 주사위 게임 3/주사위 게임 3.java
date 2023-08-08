import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(a, 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        if (map.size() == 1) {
            answer = 1111 * a;
        } else if (map.size() == 2) {
            if (map.get(a) != 2) {
                for (int key : keySet) {
                    if (map.get(key) == 1) {
                        answer += key;
                    } else{
                        answer += 10 * key;
                    }
                }
                answer *= answer;
            } else {
                int q = keySet.get(0);
                int p = keySet.get(1);
                answer = p * p - q * q;
            }
        } else if (map.size() == 3) {
            answer = 1;
            for (int key : keySet) {
                if (map.get(key) == 1) {
                    answer *= key;
                }
            }
        } else {
            answer = keySet.get(0);
        }
        
        return answer;
    }
}