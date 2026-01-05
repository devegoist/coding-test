class Solution {
    public String longestPalindrome(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            int[] r1 = expand(s, i, i);
            int[] r2 = expand(s, i, i+1);

            String s1 = s.substring(r1[0], r1[1] + 1);
            String s2 = s.substring(r2[0], r2[1] + 1);
            String longer = s1.length() > s2.length() ? s1 : s2;

            if (longer.length() > result.length()) {
                result = longer;
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