import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] split = polynomial.split(" ");
        int a = 0;
        int b = 0;
        
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains("x")) {
                String numStr = split[i].substring(0, split[i].length() - 1);
                a += numStr.equals("") ? 1 : Integer.parseInt(numStr);
            } else if (split[i].equals("+")){
                
            } else {
                b += Integer.parseInt(split[i]);
            }
        }
        
        if (a != 0) {
            answer = a != 1 ? a + "x" : "x";
            
            if (b != 0) {
                answer += " + " + b;
            }
        }
        else {
            answer = b + "";
        }
        
        return answer;
    }
}