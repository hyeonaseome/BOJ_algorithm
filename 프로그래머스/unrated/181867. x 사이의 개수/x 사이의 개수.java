class Solution {
    public int[] solution(String myString) {
        String[] split = myString.split("x");
        int len = myString.charAt(myString.length() - 1) == 'x' ? split.length + 1 : split.length;
        int[] answer = new int[len];
        for (int i = 0; i < split.length; i++) {
            answer[i] = split[i].length();
        }
        return answer;
    }
}