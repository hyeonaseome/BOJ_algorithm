import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int startIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < arr.length; i++) {
            if (startIdx == -1 && arr[i] == 2) {
                startIdx = i;
            }
            if (endIdx == -1 && arr[arr.length - i - 1] == 2) {
                endIdx = arr.length - i - 1;
            }
            if (startIdx != -1 && endIdx != -1) {
                break;
            }
        }
        
        if (startIdx != -1 && endIdx != -1) {
            answer = Arrays.copyOfRange(arr, startIdx, endIdx + 1);
        }
        return answer;
    }
}