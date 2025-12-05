class Solution {
    public String convertToTitle(int columnNumber) {
        String a = "ZABCDEFGHIJKLMNOPQRSTUVWXY";

        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int r = columnNumber % 26;
            int v = columnNumber / 26;

            if (r == 0) {
                sb.insert(0, a.charAt(r));
                columnNumber = v - 1;
            } else {
                sb.insert(0, a.charAt(r));
                columnNumber = v;
            }
        }
        return sb.toString();
    }
}