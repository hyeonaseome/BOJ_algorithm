import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        Map<String, String> map = new HashMap<>();
        
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (int i = 0; i < 26; i++) {
            map.put(morseCode[i], (char) ('a' + i) + "");
        }
        
        String[] split = letter.split(" ");
        for (String str : split) {
            answer += map.get(str);
        }
        return answer;
    }
}