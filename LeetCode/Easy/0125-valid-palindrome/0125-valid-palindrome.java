class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (isAlphaNumeric(c)) {
                sb.append(c);
            }
        }

        String s1 = sb.toString();
        String s2 = sb.reverse().toString();

        return s1.equals(s2);
    }

    private boolean isAlphaNumeric(char c) {
        return ('a' <= c && c <= 'z') || ('0' <= c && c <= '9');
    }
}