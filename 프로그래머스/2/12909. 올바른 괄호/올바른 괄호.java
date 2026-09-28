class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int left = 0;
        int right = 0;
        
        for (char c: s.toCharArray()) {
            if ('(' == c) {
                left++;
            } else {
                right++;
            }
            
            if (right > left) {
                return false;
            }
        }
        
        if (left != right) {
            return false;
        }
        
        return answer;
    }
}