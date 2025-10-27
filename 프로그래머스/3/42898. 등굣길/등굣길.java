class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] routes = new int[n + 1][m + 1];
        
        // 물 웅덩이 세팅
        for (int[] puddle: puddles) {
            routes[puddle[1]][puddle[0]] = -1;
        }
        
        // 기본값 세팅
        routes[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            if (routes[i][1] == -1) {
                routes[i][1] = 0;
            } else {
                routes[i][1] = routes[i-1][1];
            }
        }
        
        for (int i = 2; i <= m; i++) {
            if (routes[1][i] == -1) {
                routes[1][i] = 0;
            } else {
                routes[1][i] = routes[1][i-1];
            }
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (routes[i][j] == -1) {
                    routes[i][j] = 0;
                } else {
                    routes[i][j] = (routes[i-1][j] + routes[i][j-1]) % 1_000_000_007;
                }
            }
        }
        
        return routes[n][m];
    }
}