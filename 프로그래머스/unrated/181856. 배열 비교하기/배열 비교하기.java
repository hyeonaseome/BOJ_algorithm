class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        if (arr1.length > arr2.length) {
            answer = 1;
        } else if (arr1.length < arr2.length ) {
            answer = -1;
        } else {
            int sum1 = getSum(arr1);
            int sum2 = getSum(arr2);

            if (sum1 > sum2) answer = 1;
            if (sum2 > sum1) answer = -1;
        }
        return answer;
    }
    
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}