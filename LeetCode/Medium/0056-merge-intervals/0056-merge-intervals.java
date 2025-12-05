class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        // sorting
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);

            int start2 = intervals[i][0];
            int end2 = intervals[i][1];

            if (start2 <= end) {
                end = Math.max(end, end2);
            } else {
                result.add(new int[]{start, end});
                start = start2;
                end = end2;
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}