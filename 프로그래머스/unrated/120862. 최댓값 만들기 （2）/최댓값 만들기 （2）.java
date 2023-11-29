import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;  
        Arrays.sort(numbers);

        int A = numbers[0] * numbers[1];
        int B = numbers[numbers.length - 1] * numbers[numbers.length -2];
        answer = A >= B ? A : B;
        return answer;
    }
}