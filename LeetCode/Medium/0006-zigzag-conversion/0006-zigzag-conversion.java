class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int current = 0;
        boolean down = true;

        for (char c: s.toCharArray()) {
            rows[current].append(c);

            if (current == 0) {
                down = true;
            } else if (current == numRows - 1) {
                down = false;
            }

            if (down) {
                current++;
            } else {
                current--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row: rows) {
            sb.append(row);
        }

        return sb.toString();
    }
}