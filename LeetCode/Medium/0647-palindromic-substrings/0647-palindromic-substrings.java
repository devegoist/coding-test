class Solution {
    private int count = 0;
    public int countSubstrings(String s) {
        int length = s.length();
        int len = 1;

        for (int i = 0; i < length; i++) {
            search(s, i, i);
            search(s, i, i+1);
        }

        return count;
    }

    private void search(String s, int left, int right) {
        while(left >= 0 
            && right < s.length() 
            && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}