package GraphDSU;


import java.util.HashMap;
import java.util.Map;

public class LargestComponetSizeByCommonFactor {
  /**
   * 将每一个数的因子算出 再将这些因子相同的数union起来 最后计算parent 中数量最大的一个
   * @param A
   * @return
   */
  public int largestComponentSize(int[] A) {
    // 获得数组中最大值
    int max = 0;
    for (int i = 0; i < A.length; i++) {
      max = Math.max(max, A[i]);
    }
    // System.out.println(max);
    DSU dsu = new DSU(max + 1);
    for (int a : A) {
      for (int k = 2; k <= Math.sqrt(a); k++) {
        if (a % k == 0) {
          // 将 a的因子union在一起
          dsu.union(a, k);
          dsu.union(a, a / k);
        }
      }
    }
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 1;
    for (int a : A) {
      int temp = map.getOrDefault(dsu.find(a), 0) + 1;
      ans = Math.max(ans, temp);
      map.put(dsu.find(a), temp);
    }
    return ans;
  }
}

//class DSU {
//  public int[] parent;
//
//  public DSU(int n) {
//    parent = new int[n];
//    for (int i = 0; i < n; i++) {
//      parent[i] = i;
//    }
//  }
//
//  public int find(int x) {
//    if (parent[x] != x) parent[x] = find(parent[x]);
//    return parent[x];
//  }
//
//  public void union(int x, int y) {
//    parent[find(x)] = parent[find(y)];
//  }
//}
