package DivideAndConqure;
import java.util.*;
public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int K) {
      int[][] ans = new int[K][2];//初始化结果列表
      int[] dists = new int[points.length];
      for (int i=0;i<points.length;i++){
        dists[i] = dist(points[i]);
      }
      Arrays.sort(dists);
      int distK = dists[K-1];
      int t = 0;
      for (int i=0;i<points.length;i++){
        if (dist(points[i])<=distK){
          ans[t++] = points[i];
        }
      }
      return ans;

    }
    public int dist(int[] p){
      return p[0]*p[0]+p[1]*p[1];
    }


  public static void main(String[] args) {

      KClosestPointToOrigin k = new KClosestPointToOrigin();
      int [][] a ={{1,2},{2,3}};
      int b = 1;
      int [][] p = k.kClosest(a,b);
  }
}
