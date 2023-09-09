class Solution {
    public int[] solution(int[][] arr) {
        
        return countNum(arr, 0, 0, arr.length);
    }
    
    public int[] countNum(int[][] arr, int x, int y, int len) {
        
        int mark = arr[x][y];
        boolean isAllSame = true;
        
        loop:
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != mark) {
                    isAllSame = false;
                    break loop;
                }
            }
        }
        
        if (isAllSame) {
            int zeroCount = 0;
            int oneCount = 0;
            if (mark == 0) {
                zeroCount = 1;
            } else {
                oneCount = 1;
            }
            return new int[] {zeroCount, oneCount};
        } else {
            int newLen = len/2;
            
            int[] one = countNum(arr, x, y, newLen);
            int[] two = countNum(arr, x + newLen, y, newLen);
            int[] three = countNum(arr, x, y + newLen, newLen);
            int[] four = countNum(arr, x + newLen, y + newLen, newLen);
            
            int zeroCount = one[0] + two[0] + three[0] + four[0];
            int oneCount = one[1] + two[1] + three[1] + four[1];
            
            return new int[] {zeroCount, oneCount};
            
        }
    }
}