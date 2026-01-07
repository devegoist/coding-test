class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (char[] row: board) {
            for (char val: row) {
                if (val != '.' && !set.add(val)) {
                    return false;
                }
            }
            set.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) {
                    return false;
                }
            }
            set.clear();
        }

        Set<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int box = (i / 3) * 3 + (j / 3);
                if (boxes[box] == null) {
                    boxes[box] = new HashSet<>();
                }

                if (board[i][j] != '.' && !boxes[box].add(board[i][j])) {
                    return false;
                }
            }
        }
        

        return true;
    }
}