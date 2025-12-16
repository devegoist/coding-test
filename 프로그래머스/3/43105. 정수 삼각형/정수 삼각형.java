class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            if (dp[i] == null) {
                dp[i] = new int[triangle[i].length];    
            }
        }
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for (int j = 1; j < dp[i].length; j++) {
                dp[j][j] = dp[j-1][j-1] + triangle[j][j];
            }
        }
        
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length - 1; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                if (i == dp.length - 1) {
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        return answer;
    }
}