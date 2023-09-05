class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int fac = 1;
        while (true) {
            if (fac > n) {
                break;
            }
            fac *= ++answer;
        }
        return --answer;
    }
}