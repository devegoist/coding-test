import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = (arr.length + 1) / 2;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i * 2]);
            maxDp[i][i] = num;
            minDp[i][i] = num;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    String op = arr[(k * 2) + 1];
                    
                    if ("+".equals(op)) {
                        int maxVal = maxDp[i][k] + maxDp[k+1][j];
                        int minVal = minDp[i][k] + minDp[k+1][j];
                        max = Math.max(max, maxVal);
                        min = Math.min(min, minVal);
                    } else {
                        int maxVal = maxDp[i][k] - minDp[k+1][j];
                        int minVal = minDp[i][k] - maxDp[k+1][j];
                        max = Math.max(max, maxVal);
                        min = Math.min(min, minVal);
                    }
                }
                
                maxDp[i][j] = max;
                minDp[i][j] = min;
            }
        }
        
        return maxDp[0][n - 1];
    }
}