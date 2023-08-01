class Solution {
    public static int[] memo;
    public int solution(int n) {
        memo = new int[n + 1];

        return fibo(n) % 1234567;
    }
    private static int fibo(int n) {
        if (n == 0) {
            return memo[0];
        }
        if (n == 1) {
            memo[1] = 1;
            return memo[1];
        }
        if (memo[n] == 0) {
            memo[n] = fibo(n - 1) + fibo(n - 2);
        }
        return memo[n] % 1234567;
    }
}