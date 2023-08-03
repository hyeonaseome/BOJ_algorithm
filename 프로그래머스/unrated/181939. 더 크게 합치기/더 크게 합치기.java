class Solution {
    public int solution(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        int ab = Integer.parseInt(strA + strB);
        int ba = Integer.parseInt(strB + strA);
        int answer = Math.max(ab, ba);
        return answer;
    }
}