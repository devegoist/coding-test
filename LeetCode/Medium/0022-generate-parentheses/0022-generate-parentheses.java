class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        process(n, 0, 0, sb, result);
        return result;
    }

    private void process(int n, int open, int closed, StringBuilder sb, List<String> result) {
        if (open == n && closed == n) {
            result.add(sb.toString());
            return;
        }

        if (open <= n) {
            process(n, open+1, closed, sb.append("("), result); //open
            sb.deleteCharAt(sb.length()-1);
        }
        if (closed < open) {
            process(n, open, closed+1, sb.append(")"), result); //closed
            sb.deleteCharAt(sb.length()-1);
        }
    }
}