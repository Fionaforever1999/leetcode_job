package DFS;

import java.util.ArrayList;
import java.util.List;

public class PlaticAtlanticOceans {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
      List<List<Integer>> ans = new ArrayList<>();
      if (matrix.length==0)return ans;
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] pacific = new int[row][col];
      int[][] atlantic = new int[row][col];
      for(int i=0;i<row;i++){
        // pacific left + top
        dfs(matrix, i, 0, 0, pacific);
        dfs(matrix, i, col-1, 0, atlantic);
      }
      for (int j=0;j<col;j++){
        // atlantic right + bottom
        dfs(matrix, 0, j, 0, pacific);
        dfs(matrix, row-1, j, 0, atlantic);
      }

      List<Integer> temp = new ArrayList<>();

      for(int x=0;x<row;x++){
        for(int y=0;y<col;y++){
          // if the corrdinate is right add into the ans
          temp = new ArrayList<>();
          temp.add(x);
          temp.add(y);
          if(pacific[x][y]==1&&atlantic[x][y]==1) ans.add(temp);
        }
      }
      return ans;


    }
    int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs(int[][] matrix, int row, int col, int h, int[][] v){
      if(row<0 || col<0 || row>= matrix.length || col >= matrix[0].length)return;
      if(v[row][col] ==1 || matrix[row][col] < h) return;
      v[row][col] = 1;
      for(int m=0; m<4;m++){
        dfs(matrix, row+d[m][0], col+d[m][1],matrix[row][col],v);
      }

    }
  }
