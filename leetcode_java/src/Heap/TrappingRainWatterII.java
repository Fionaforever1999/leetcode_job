package Heap;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


class TrappingRainWatterII {
  public int trapRainWater(int[][] heightMap) {
    int cols = heightMap[0].length;
    int rows = heightMap.length;
    boolean[][] vist = new boolean[rows][cols]; //define if visted
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);// 取最小值的pq
    for(int i=0; i<rows;i++){
      for(int j=0;j<cols;j++){
        if (i==0 || i==rows-1 || j==0||j==cols-1){
          pq.offer(new int[]{i,j,heightMap[i][j]}); //将边界值内容加入组成的数组中
          vist[i][j] = true;
        }
      }
    }
    int res = 0;
    int[] dirs = {-1,0,1,0,-1};//将方向数组存入
    while (!pq.isEmpty()){
      // 建立在pq非空条件下
      int[] node = pq.poll();
      for(int k=0;k<4 ;k++){
        //四个方向实现 两个方程错开
        int x = node[0] + dirs[k];
        int y = node[1] + dirs[k + 1];//错开两个方向
        if (x>=0 && x<rows && y>=0 && y<cols &&!vist[x][y]){
          if(node[2]>heightMap[x][y]){
            res += node[2] - heightMap[x][y];
          }
          pq.offer(new int[]{x, y, Math.max(heightMap[x][y], node[2])});
          vist[x][y] = true;
        }
      }
    }
    return res;
  }
}

