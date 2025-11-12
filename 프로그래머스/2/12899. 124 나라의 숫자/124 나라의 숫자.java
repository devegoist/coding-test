class Solution {
    public String solution(int n) {
        int[] nums = {4,1,2};
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            int r = n % 3;
            if (r == 0) {
                n = (n / 3) - 1;
            } else {
                n = n / 3;
            }

            sb.append(nums[r]);
            
            if (n == 0) {
                break;
            }
        }
        
        return sb.reverse().toString();
    }
}