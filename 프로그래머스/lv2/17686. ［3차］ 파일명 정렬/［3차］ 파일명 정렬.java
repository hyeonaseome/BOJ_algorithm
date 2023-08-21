import java.util.*;

class Solution {
    public class File implements Comparable<File>{
        String origin;
        String head;
        String number;
        String tail;
        int idx;
        
        public File (String origin, String head, String number, String tail, int idx) {
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(File f) {
            if (!this.head.toLowerCase().equals(f.head.toLowerCase())) {
                return this.head.toLowerCase().compareTo(f.head.toLowerCase());
            }
            
            if (Integer.parseInt(this.number) != Integer.parseInt(f.number)) {
                return Integer.parseInt(this.number) - Integer.parseInt(f.number);
            }
            
            return this.idx - f.idx;
        }
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> list = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            int numStart = -1;
            int numEnd = -1;
            for (int j = 1; j < files[i].length(); j++) {
                int charNum = files[i].charAt(j) - '0';
            
                if (0 <= charNum && charNum <= 9) {
                    if (numStart == -1) {
                        numStart = j;
                    }
                    numEnd = j;
                } else {
                    if (numEnd != -1) {
                        break;
                    }
                }
            }
            String head = files[i].substring(0, numStart);
            String number = files[i].substring(numStart, numEnd + 1);
            String tail = files[i].substring(numEnd);
            
            list.add(new File(files[i], head, number, tail, i));
        }
        
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).origin;
        }  
        return answer;
    }
}