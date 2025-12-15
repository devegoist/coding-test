class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 0L;
        int[] dp = new int[prices.length];
        dp[0] = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] - prices[i] == 1) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        for (int d: dp) {
            result += d;
        }

        return result;
    }
}