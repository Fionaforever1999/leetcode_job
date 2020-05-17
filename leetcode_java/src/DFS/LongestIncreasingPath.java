package DFS;

public class LongestIncreasingPath {
    private int rows;
    private int cols;
    private static final int[][] settle ={{0,1},{0,-1},{1,0},{-1,0}};
    // 利用 cache 来存储已经出现过的字段
    public int longestIncreasingPath(int[][] matrix) {
      if (matrix.length==0)return 0;
      rows = matrix.length;
      cols = matrix[0].length;
      int ans = 0;
      int[][] cache = new int[rows][cols];
//      System.out.println(cache[0][0]);
      for (int i=0;i<rows;i++){
        for (int j=0;j<cols;j++){
          System.out.println(dfs(matrix, i, j, cache));
          ans = Math.max(dfs(matrix, i, j, cache), ans);
        }
      }
      return ans;


    }
    public int dfs (int[][] matrix,int i, int j, int[][] cache){
      if (cache[i][j]!=0)return cache[i][j]; // 如果这个值在其他情况下已经有值就返回
      for(int[] d: settle){
        int x = d[0] + i;
        int y = d[1] + j;
        if(x>=0&&y>=0&&x<rows&&y<cols&&matrix[x][y]>matrix[i][j])
          cache[i][j] = Math.max(dfs(matrix, x,y, cache), cache[i][j]);
      }
      return ++cache[i][j]; //先+1后用i
    }

  public static void main(String[] args) {
      LongestIncreasingPath p = new LongestIncreasingPath();
      int[][] a = {{9,9,4},{6,6,8},{2,1,1}};
      System.out.println(p.longestIncreasingPath(a));
  }
}
