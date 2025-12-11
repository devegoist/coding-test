class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums); // nLogn
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i+1]) {
        //         return true;
        //     }
        // }
        // return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;
    }
}