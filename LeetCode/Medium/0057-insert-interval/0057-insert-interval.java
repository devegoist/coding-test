class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        boolean used = false;

        for (int[] current: intervals) {
            int start = current[0];
            int end = current[1];

            if (end < newInterval[0]) {
                result.add(current);
            } else if (newInterval[1] < start) {
                if (!used) {
                    result.add(newInterval);
                    used = true;
                }
                result.add(current);
            } else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }

        if (!used) {
            result.add(newInterval);
        }
        
        return result.toArray(int[][]::new);
    }
}