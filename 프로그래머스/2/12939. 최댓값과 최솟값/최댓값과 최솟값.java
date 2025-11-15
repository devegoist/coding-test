class Solution {
    public String solution(String s) {
        
        String[] strs = s.split(" ");
        
        int min = Integer.parseInt(strs[0]);
        int max = Integer.parseInt(strs[0]);
        
        for (String str : strs) {
            min = Math.min(min, Integer.parseInt(str));
            max = Math.max(max, Integer.parseInt(str));
        }
        
        return min + " " + max;
    }
}