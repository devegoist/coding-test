class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int[] interval: intervals) {
            result.add(interval);
        }
        result.add(newInterval);

        intervals = result.toArray(int[][]::new);
        result.clear();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (end >= start2) {
                end = Math.max(end, end2);
            } else {
                result.add(new int[]{start, end});
                start = start2;
                end = end2;
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(int[][]::new);
    }
}