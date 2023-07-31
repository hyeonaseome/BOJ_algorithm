class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        answer = min + " "+ max;
        return answer;
    }
}