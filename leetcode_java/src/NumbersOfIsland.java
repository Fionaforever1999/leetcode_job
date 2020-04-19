//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  private int result = 0;// 定义class instance 类的实例
  private int m;
  private int n;
  public int numIslands(char[][] grid) {
    if (grid.length==0 || grid[0].length == 0)return 0;
    m = grid.length;
    n = grid[0].length;
    for(int i=0;i < m;i++){
      for(int j = 0; j< n;j++){
        if(grid[i][j] == '0')continue;// 如果不是前往下一个节点
        dfs(grid, i, j);
        result ++;
      }
    }
    return result;
  }
  //因为要调用private varible 所以不是static
  private void dfs(char[][] grid, int i, int j){
    // 如果超出就不用查了
    if (i < 0 || j < 0 || i >= m || j >= n)return;
    if (grid[i][j] == '0')return;
    grid[i][j] ='0';
    // 找上下左右
    dfs(grid,i - 1,j);
    dfs(grid,i,j - 1);
    dfs(grid,i + 1,j);
    dfs(grid,i,j + 1);
  }
}
//leetcode submit region end(Prohibit modification and deletion)
