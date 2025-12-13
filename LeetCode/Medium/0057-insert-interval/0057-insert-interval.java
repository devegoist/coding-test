class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean merged = false;
        
        for (int[] curr : intervals) {
            if (curr[1] < newInterval[0]) {
                result.add(curr);
            } else if (curr[0] > newInterval[1]) {
                if (!merged) {
                    result.add(newInterval);
                    merged = true;
                }
                result.add(curr);
            } else {
                newInterval[0] = Math.min(newInterval[0], curr[0]);
                newInterval[1] = Math.max(newInterval[1], curr[1]);
            }
        }
        
        if (!merged) result.add(newInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}