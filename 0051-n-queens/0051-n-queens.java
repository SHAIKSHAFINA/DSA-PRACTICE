class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] row = new boolean[n];
        boolean[] dia = new boolean[2 * n - 1];
        boolean[] antiDia = new boolean[2 * n - 1];

        solve(n, 0, board, row, dia, antiDia);
        return ans;
    }

    void solve(int n, int col, char[][] board,
               boolean[] row, boolean[] dia, boolean[] antiDia) {

        if (col == n) {
            
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!row[i] && !dia[i + col] && !antiDia[i - col + n - 1]) {

                
                board[i][col] = 'Q';
                row[i] = true;
                dia[i + col] = true;
                antiDia[i - col + n - 1] = true;

                solve(n, col + 1, board, row, dia, antiDia);

               
                board[i][col] = '.';
                row[i] = false;
                dia[i + col] = false;
                antiDia[i - col + n - 1] = false;
            }
        }
    }
}