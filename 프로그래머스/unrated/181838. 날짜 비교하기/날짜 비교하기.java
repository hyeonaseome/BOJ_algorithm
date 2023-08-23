class Solution {
    public int solution(int[] date1, int[] date2) {
        int d1 = date1[0] *365 + date1[1] * 30 + date1[2];
        int d2 = date2[0] *365 + date2[1] * 30 + date2[2];
        return d1 < d2 ? 1 : 0;
    }
}