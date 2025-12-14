class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        process(n, 0, 0, "", result);
        return result;
    }

    private void process(int n, int open, int closed, String str, List<String> result) {
        if (open == n && closed == n) {
            result.add(str);
            return;
        }

        if (open <= n) {
            process(n, open+1, closed, str+"(", result); //open
        }
        if (closed < open) {
            process(n, open, closed+1, str+")", result); //closed
        }
    }
}