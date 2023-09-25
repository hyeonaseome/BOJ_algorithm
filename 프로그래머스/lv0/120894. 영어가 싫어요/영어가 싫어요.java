class Solution {
    public long solution(String numbers) {
        String answerStr = "";
        String[] numStrs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        while (numbers.length() > 0) {
            for (int i = 0; i < 10; i++) {
                if (numbers.startsWith(numStrs[i])) {
                    numbers = numbers.substring(numStrs[i].length());
                    answerStr += i;
                    break;
                }
            }
        }
        
        return Long.parseLong(answerStr);
    }
}