import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> idToNickname = new HashMap<>();
        
        List<String> userIds = new ArrayList<>();
        List<String> EorL = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if (split[0].equals("Enter")) {
                userIds.add(split[1]);
                EorL.add("E");
                idToNickname.put(split[1], split[2]);
            } else if (split[0].equals("Leave")) {
                userIds.add(split[1]);
                EorL.add("L");
            } else {
                idToNickname.put(split[1], split[2]);
            }
        }
        
        String[] answer = new String[userIds.size()];
        for (int i = 0; i < userIds.size(); i++) {
            answer[i] = idToNickname.get(userIds.get(i));
            answer[i] += EorL.get(i).equals("E") ? "님이 들어왔습니다." : "님이 나갔습니다.";
        }
        return answer;
    }
}