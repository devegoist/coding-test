class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            int[] r1 = expand(s, i, i);
            int[] r2 = expand(s, i, i+1);

            if (r1[1] - r1[0] > r2[1] - r2[0]) {
                result = result.length() < r1[1] + 1 - r1[0] ? s.substring(r1[0], r1[1] + 1) : result;
            } else {
                result = result.length() < r2[1] + 1 - r2[0] ? s.substring(r2[0], r2[1] + 1) : result;
            }
        }

        return result;
    }

    private int[] expand(String s, int left, int right) {
        while(left >= 0 
            && right <= s.length() - 1
            && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}