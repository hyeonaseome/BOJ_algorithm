import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replaceAll("b", "a").replaceAll("c", "a");
        String[] split = myStr.split("a");
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals(""))
                list.add(split[i]);
        }
        String[] answer = list.toArray(String[]::new);
        if (answer.length == 0) {
            answer = new String[] {"EMPTY"};
        }
        return answer;
    }
}