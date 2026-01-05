class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        boolean isOdd = s.length() % 2 == 0 ? false : true;

        for (int i = 0; i < s.length(); i++) {
            String str1 = expand(s, i, i);
            String str2 = expand(s, i, i+1);

            result = str1.length() > result.length() ? str1 : result;
            result = str2.length() > result.length() ? str2 : result;
        }

        return result;
    }

    private String expand(String s, int left, int right) {
        StringBuilder sb = new StringBuilder();
        while(left >= 0 
            && right <= s.length() - 1
            && s.charAt(left) == s.charAt(right)) {

            if (left == right) {
                sb.append(s.charAt(left));
            } else {
                sb.insert(0, s.charAt(left));
                sb.append(s.charAt(right));
            }
            left--;
            right++;
        }
        return sb.toString();
    }
}