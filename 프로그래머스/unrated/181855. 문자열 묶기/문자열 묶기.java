class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        
        int[] strArrLen = new int[31];
        
        for (int i = 0; i < strArr.length; i++) {
            int len = strArr[i].length();
            strArrLen[len]++;
            answer = strArrLen[len] > answer ? strArrLen[len] : answer;
        }
        return answer;
    }
}