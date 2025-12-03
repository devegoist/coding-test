class Solution {
    public boolean hasMatch(String s, String p) {
        String[] split = p.split("\\*", -1);
        int length1 = split[0].length();
        int length2 = 0;

        int idx1 = s.indexOf(split[0]);
        if (idx1 < 0) {
            return false;
        }

        s = s.substring(idx1 + length1);
        return s.indexOf(split[1]) >= 0 ? true : false;
    }
}