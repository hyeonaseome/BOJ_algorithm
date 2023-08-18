class Solution {
    public int solution(String binomial) {
        String[] split = binomial.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[2]);
        
        int answer = a;
        switch(split[1].charAt(0)) {
            case '+':
                answer += b;
                break;
            case '-':
                answer -= b;
                break;
            case '*':
                answer *= b;
                break;
        }
        return answer;
    }
}