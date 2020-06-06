package DFS;

public class Minesweeper529 {
  int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 相邻位置
  int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


  public char[][] updateBoard(char[][] board, int[] click) {
    // 扫雷游戏
    dfs(board, click[0], click[1]);
    return board;
  }

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public void dfs(char[][] board, int x, int y) {
    int row = board.length;
    int col = board[0].length;
    if (x < 0 || y < 0 || x >= row || y >= col) return;
    if (board[x][y] == 'E') {
      board[x][y] = 'B';

      int count = judge(board, x, y);
      if (count == 0) {
        for (int i = 0; i < 8; i++) {
          dfs(board, x + dx[i], y + dy[i]);
        }
      } else {
        board[x][y] = (char) ('0' + count);
      }
    } else if (board[x][y] == 'M') {
      board[x][y] = 'X';
    }
  }

  public int judge(char[][] board, int x, int y) {
    // 判断距离雷有几个
    int row = board.length;
    int col = board[0].length;
    int count = 0;
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
      if (board[nx][ny] == 'M') {
        count++;
      }
    }
    return count;
  }
}
