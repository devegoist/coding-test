class Solution {
    public boolean isPalindrome(String s) {
        // 수박이박수
        String condition = "abcdefghijklmnopqrstuvwxyz0123456789";

        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isAlphanumeric(c)) {
                sb.append(c);
            }
        }

        String a = sb.toString();
        String b = sb.reverse().toString();

        return a.equals(b);
    }

    private boolean isAlphanumeric(char c) {
    return (c >= '0' && c <= '9') ||
           (c >= 'a' && c <= 'z');
}
}