class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        // sorting
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
            
            if (intervals[i][0] <= end && end <= intervals[i][1]) {
                end = intervals[i][1];
            } else if (intervals[i][0] <= end && intervals[i][1] <= end) {
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }

            if (intervals.length - 1 == i) {
                result.add(new int[]{start, end});
            }
        }

        if (intervals.length == 1) {
            result.add(new int[]{start, end});
        }

        return result.toArray(int[][]::new);
    }
}