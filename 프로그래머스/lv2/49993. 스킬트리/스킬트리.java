class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int[] skillOrder = new int[26];
        for (int i = 0; i < skill.length(); i++) {
            skillOrder[skill.charAt(i) - 'A'] = i + 1;
        }
        for (int i = 0; i < skill_trees.length; i++) {
            int cnt = 0;
            boolean isPossible = true;
            
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (cnt == skill.length()) {
                    break;
                }
                
                char cur = skill_trees[i].charAt(j);
                if (cur == skill.charAt(cnt)) {
                    cnt++;
                    continue;
                }
                
                if (skillOrder[cur - 'A'] != 0 && skillOrder[cur - 'A'] > cnt) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }
        }
        return answer;
    }
}