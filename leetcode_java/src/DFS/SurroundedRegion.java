package DFS;

public class SurroundedRegion {
  class Solution {
    public void solve(char[][] board) {
      if (board == null || board.length == 0) return;
      int row = board.length;
      int col = board[0].length;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
            dfs(board, i, j);//if on the board into dfs
          }
        }
      }
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (board[i][j] == 'O') board[i][j] = 'X';
          if (board[i][j] == '#') board[i][j] = 'O';

        }
      }
    }

    public void dfs(char[][] board, int i, int j) {
      int row = board.length;
      int col = board[0].length;
      if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] == 'X' || board[i][j] == '#') {
        //
        return;//如果i,j 没有超过范围而且没有被遍历过，而且不是X就赋值为#
      }
      board[i][j] = '#';
      dfs(board, i - 1, j);
      dfs(board, i, j - 1);
      dfs(board, i + 1, j);
      dfs(board, i, j + 1);
    }
  }
}
