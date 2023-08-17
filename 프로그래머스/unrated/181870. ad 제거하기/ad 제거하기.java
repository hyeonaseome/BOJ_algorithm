import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = {};
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                list.add(strArr[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}