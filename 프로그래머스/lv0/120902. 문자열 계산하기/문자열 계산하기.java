class Solution {
    public int solution(String my_string) {
        
        String[] operator = my_string.split(" ");
        int answer = Integer.parseInt(operator[0]);
        
        for (int i = 1; i < operator.length; i++) {
            if (!operator[i].equals("+") && !operator[i].equals("-")) {
                if (operator[i - 1].equals("+")) {
                    answer += Integer.parseInt(operator[i]);
                } else {
                    answer -= Integer.parseInt(operator[i]);
                }
            };
        }
        return answer;
    }
}