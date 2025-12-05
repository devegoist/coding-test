class Solution {
    public int scoreOfString(String s) {
        char[] c = s.toCharArray();

        int result = 0;
        for (int i = 0; i < c.length - 1; i++) {
            result += Math.abs(c[i] - c[i + 1]);
        }
        return result;
    }
}