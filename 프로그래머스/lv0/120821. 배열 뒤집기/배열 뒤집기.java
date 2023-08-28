class Solution {
    public int[] solution(int[] num_list) {
        for (int i = 0; i < num_list.length / 2; i++) {
            int temp = num_list[i];
            int otherIdx = num_list.length - 1 - i;
            num_list[i] = num_list[otherIdx];
            num_list[otherIdx]  = temp;
        }
        return num_list;
    }
}