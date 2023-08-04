class Solution {
    public String solution(String code) {
        String answer = "";
        
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char character = code.charAt(i);
            if (mode == 0) {
                if (character != '1') {
                    if(i % 2 == 0)
                        answer += character;
                } else {
                    mode = 1;
                }
            } else {
                if (character != '1') {
                    if(i % 2 == 1)
                        answer += character;
                } else {
                    mode = 0;
                }
            }
            
        }
        if (answer.equals("")) {
            answer = "EMPTY";
        }
        return answer;
    }
}