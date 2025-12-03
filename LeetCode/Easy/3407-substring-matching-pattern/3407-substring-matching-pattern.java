class Solution {
    public boolean hasMatch(String s, String p) {
        int idx = p.indexOf("*");

        String left = p.substring(0, idx);
        String right = p.substring(idx + 1);

        int lIdx = s.indexOf(left);
        if (lIdx == -1) {
            return false;
        }

        int rIdx = s.substring(lIdx + left.length()).indexOf(right);
        if (rIdx == -1) {
            return false;
        }

        return true;
    }
}