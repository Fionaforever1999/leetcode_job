package GraphDSU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class possibleBinpartition {
  public Map<Integer, List<Integer>> map;
  public int[] colors;

  public boolean possibleBipartition(int N, int[][] dislikes) {
    if (dislikes == null || dislikes.length == 0) return true;
    map = new HashMap<>();
    // 建立无向图 需要预先定义 map 否则到200 时会报空指针异常
    for (int i = 0; i < N; i++) map.put(i, new ArrayList<>());
    for (int[] pair : dislikes) {
      map.computeIfAbsent(pair[0] - 1, k -> new ArrayList<>());
      map.get(pair[0] - 1).add(pair[1] - 1);
      map.computeIfAbsent(pair[1] - 1, k -> new ArrayList<>());
      map.get(pair[1] - 1).add(pair[0] - 1);
      // map.get(pair[0]-1).add(pair[1]-1);
      // map.get(pair[1]-1).add(pair[0]-1);
    }
    System.out.println(map);

    //这里建立的colors 长度是从1开始因为dislike的节点开始是1 否则在 map初始定义的时候 是pair[x] - 1
    // 0:unknown 1: red -1:blue
    // colors = new int[N + 1];
    colors = new int[N];

    // for(int i= 1;i<=N;i++){
    for (int i = 0; i < N; i++) {

      // 图没有连通分量 所以枚举所有顶点
      // dfs表示染色结果
      if (colors[i] == 0 && !dfs(i, 1)) return false;
    }
    return true;
  }

  // dfs(当前节点， 要染成的颜色)
  public boolean dfs(int cur, int color) {
    colors[cur] = color;
    // 枚举所有邻居
    // for(int i=0;i<map.get(cur).size();i++){
    //     int j = map.get(cur).get(i);
    //     if(colors[j] == color) return false;
    //     if(colors[j] == 0 && !dfs(j, -color))return false;
    // }
    for (Integer next : map.get(cur)) {
      if (colors[next] == color) return false;
      if (colors[next] == 0 && !dfs(next, -color)) return false;
    }
    return true;
  }
}
