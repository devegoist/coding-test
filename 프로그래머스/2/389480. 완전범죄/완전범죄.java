import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int N = info.length;
        int[][] dp = new int[N+1][m];
        int INF = Integer.MAX_VALUE / 2;
        
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], INF);
        }
        
        dp[0][0] = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == INF) {
                    continue;
                }
                
                int currentA = dp[i][j];
                int currentB = j;
                
                // A가 훔침
                int newA = currentA + info[i][0];
                int newB = currentB;
                
                if (newA < n) {
                    dp[i+1][newB] = Math.min(dp[i+1][newB], newA);    
                }
                
                // B
                newA = currentA;
                newB = currentB + info[i][1];
                
                if (newB < m) {
                    dp[i+1][newB] = Math.min(dp[i+1][newB], newA);    
                }
            }
        }
        
        int answer = INF;
        for (int j = 0; j < m; j++) {
            answer = Math.min(answer, dp[N][j]);
        }
    
        return answer == INF ? -1 : answer;
    }
}