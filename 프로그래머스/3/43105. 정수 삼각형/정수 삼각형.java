class Solution {
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        dp[0][0] = triangle[0][0];
        
        int result = 0;
        
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<=i; j++) {
                // 0,0
                // 1,0 1,1
                // 2,0 2,1 2,2
                if (j==0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j==i) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }
            }
        }
        
        for (int res: dp[dp.length-1]) {
            result = Math.max(result, res);
        }
        
        return result;
    }
}