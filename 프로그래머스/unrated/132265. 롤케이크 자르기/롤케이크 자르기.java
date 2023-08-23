class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] person1 = new int[10_001];
        int[] person2 = new int[10_001];
        int topping1 = 0;
        int topping2 = 0;
        for (int curTopping : topping) {
            if (person2[curTopping] == 0) {
                topping2++;
            }
            person2[curTopping]++;
        }
        
        for (int curTopping : topping) {
            if (person1[curTopping] == 0) {
                topping1++;
            }
            if (person2[curTopping] == 1) {
                topping2--;
            }
            person1[curTopping]++;
            person2[curTopping]--;

            if (topping1 == topping2) {
                answer++;
            }
        }

        return answer;
    }
}