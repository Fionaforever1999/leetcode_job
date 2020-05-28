package GraphDSU;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvaluateDIvision {

  HashMap<String, HashMap<String, Double>> graph;

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // graph求值
    graph = new HashMap<>();
    for (int i = 0; i < equations.size(); i++) {
      String A = equations.get(i).get(0);
      String B = equations.get(i).get(1);
      // computeIfAbsent 表示如果hashmap中的值不存在则 实例化新对象 嵌套hashmap
      graph.computeIfAbsent(A, k -> new HashMap<>()).put(B, values[i]);
      graph.computeIfAbsent(B, k -> new HashMap<>()).put(A, 1.0 / values[i]);
      //{a={b=2.0}, b={a=0.5, c=3.0}, c={b=0.3333333333333333}}
    }
    double[] ans = new double[queries.size()];
    for (int count = 0; count < queries.size(); count++) {
      String x = queries.get(count).get(0);
      String y = queries.get(count).get(1);
      if (!graph.containsKey(x) || !graph.containsKey(y)) {
        // 如果方程中没有x,y 返回-1
        ans[count] = -1;
        continue;
      }
      Set<String> visited = new HashSet<>();
      ans[count] = dfs(x, y, visited, graph);
    }

    return ans;
  }

  public double dfs(String A, String B, Set<String> visited, HashMap<String, HashMap<String, Double>> graph) {
    // dfs对每个传入的query求值
    if (A.equals(B)) {
      // System.out.println("A B相同");
      return 1.0;
    }
    // System.out.println("A是" + A);
    // System.out.println("B是" + B);
    visited.add(A);
    HashMap<String, Double> maps = graph.get(A);
    // System.out.println(maps);
    for (String C : maps.keySet()) {
      if (visited.contains(C)) continue;// 如果邻居C已经访问过 不做处理
      // 如果没有访问过 找C到B的路径
      // System.out.println("C是" + C);
      double d = dfs(C, B, visited, graph); // d = C/B 找到返回路径
      if (d != -1) {
        return d * graph.get(A).get(C);
      }
    }
    return -1;
  }
}
