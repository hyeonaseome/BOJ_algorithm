class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        int idx = direction.equals("right") ? numbers.length - 1 : 1;
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[(idx + i) % numbers.length];
        }
        return answer;
    }
}