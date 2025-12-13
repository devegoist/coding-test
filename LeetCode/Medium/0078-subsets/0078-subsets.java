class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;

        backtrack(0, new ArrayList<>());

        return result;
    }

    private void backtrack(int index, List<Integer> current) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        backtrack(index + 1, current);
        current.remove(current.size() - 1);

        backtrack(index + 1, current);
    }
}