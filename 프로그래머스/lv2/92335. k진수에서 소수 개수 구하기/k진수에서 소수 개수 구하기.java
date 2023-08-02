import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String strNum = Integer.toString(n, k);
        String[] split = strNum.split("0");
        
        HashSet<Long> set = new HashSet<>();
        
        for (int i = 0; i < split.length; i++) {
            
            if (split[i].equals("")) continue;
            
            long num = Long.parseLong(split[i]);
            
            if (set.contains(num)) {
                answer++;
            } else {
                if (isPrime(num)) {
                    answer++;
                    set.add(num);
                }
            }
        }
        return answer;
    }
    
    private boolean isPrime(long num) {
        
        if (num == 1L)
            return false;
        
        for (long i = 2L; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}