class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= k) {
            k = nums.length-1;
        }

        for (int i = 0; i < nums.length-k; i++) {
            for (int j = i+1; j <= i+k; j++) {
                // System.out.println(i + " " + j + " " + k);
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}