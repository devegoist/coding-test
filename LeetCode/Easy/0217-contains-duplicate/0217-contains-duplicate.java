class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums); // nLogn
        // for (int i = 0; i < nums.length - 1; i++) {
        //     if (nums[i] == nums[i+1]) {
        //         return true;
        //     }
        // }
        // return false;

        // Map<Integer, Integer> map = new HashMap<>(); O(n)
        // for (int num : nums) {
        //     if (map.containsKey(num)) {
        //         return true;
        //     }
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}