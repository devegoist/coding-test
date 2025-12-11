class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[27];

        for (char c : s.toCharArray()) {
            map[c - 96] += 1;
        }

        for (char c : t.toCharArray()) {
            map[c - 96] -= 1;
        }

        for (int m : map) {
            if (m != 0) {
                return false;
            }
        }
        
        return true;
    }
}