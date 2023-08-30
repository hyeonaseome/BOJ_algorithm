class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                String numStr = "0" + Long.toBinaryString(num);
                int lastZeroIdx = numStr.lastIndexOf("0");
                String newStr = numStr.substring(0, lastZeroIdx) + "10" + numStr.substring(lastZeroIdx + 2);
                answer[i] = Long.parseLong(newStr, 2);
            }
        }
        return answer;
    }
}