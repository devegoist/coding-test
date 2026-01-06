class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length()-len; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j] == true) {
                    result+=1;
                }
            }
        }

        return result;
    }
}