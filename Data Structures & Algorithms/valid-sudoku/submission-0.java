class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        HashSet<Integer>[] row = new HashSet[n];
        HashSet<Integer>[] col = new HashSet[n];
        HashSet<Integer>[] square = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == '.')
                    continue;
                int val = board[i][j] - '0';
                int square_ind = (i / 3) * 3 + j / 3;
                if (row[i].contains(val) || col[j].contains(val)
                    || square[square_ind].contains(val)) {
                    return false;
                }
                row[i].add(val);
                col[j].add(val);
                square[square_ind].add(val);
            }
        }
        return true;
    }
}
