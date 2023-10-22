class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        int i = 0;
        for (String expression : quiz) {
            String[] split = expression.split(" ");
            
            int first = Integer.parseInt(split[0]);
            int second = Integer.parseInt(split[2]);
            
            int left = split[1].equals("+") ? first + second : first - second;
            answer[i++] = left == Integer.parseInt(split[4]) ? "O" : "X";
        }
        
        return answer;
    }
}