import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[]{ -1 };
        for (int i = l; i <= r; i++) {
            if (i % 5 == 0) {
                int mod = 1_000_000;
                
                int cur = i;
                boolean flag = true;
                for (int j = 0; j < 6; j++) {
                    if (!(cur / mod == 0 || cur / mod == 5)) {
                        flag = false;
                        break;
                    }
                    cur %= mod;
                    mod /= 10;
                }
                
                if (flag) {
                    list.add(i);
                }
                i += 4;
            }
        }

        if (list.size() > 0) {
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        return answer;
    }
}