import java.util.*;
class Solution {
    public String[] solution(String myString) {
        String[] split = myString.split("x");
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i <split.length; i++) {
            if (!split[i].equals("")) {
                list.add(split[i]);
            }
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
}