package Graph;
//https://leetcode-cn.com/problems/is-graph-bipartite/solution/pan-duan-er-fen-tu-by-leetcode/
public class IsGraphBipartite {
  public boolean isBipartite(int[][] graph) {
    if (graph.length == 0 || graph == null) return false;
    int n = graph.length;
    int[] color = new int[n]; // 染色 0未染色 1 黑 2 白
    for (int i = 0; i < n; i++) {
      if (!dfs(color, i, graph, 0)) return false;
    }
    return true;
  }

  public boolean dfs(int[] color, int i, int[][] graph, int lastColor) {
    if (color[i] != 0) return color[i] != lastColor;
    color[i] = lastColor == 1 ? 2 : 1;
    for (int j = 0; j < graph[i].length; j++) {
      if (!dfs(color, graph[i][j], graph, color[i])) return false;
    }
    return true;
  }
}
