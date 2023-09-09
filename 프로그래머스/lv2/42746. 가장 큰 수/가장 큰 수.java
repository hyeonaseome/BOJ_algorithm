import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] numbersStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(numbersStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) { 
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        int zeroCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            answer += numbersStr[i];
            zeroCount += numbersStr[i].equals("0") ? 1 : 0;
        }
        
        if (zeroCount == numbers.length) {
            answer = "0";
        }
        
        return answer;
    }
}