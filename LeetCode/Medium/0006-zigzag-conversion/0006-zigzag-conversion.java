class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int current = 0;
        boolean down = true;

        for (String str: s.split("")) {
            rows[current].append(str);

            if (down) {
                current+=1;
                if (current == numRows-1) {
                    down = false;
                }
            } else {
                current--;
                if (current == 0) {
                    down = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder row: rows) {
            sb.append(row.toString());
        }

        return sb.toString();
    }
}