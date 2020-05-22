public class ReduntConnection {
  public int[] findRedundantConnection(int[][] edges) {
    int[] parent = new int[edges.length + 1];
    int[] size = new int[edges.length + 1];
    for (int i = 0; i < size.length; i++) {
      size[i] = 1;
    }
    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      if (parent[u] == 0) parent[u] = u;
      if (parent[v] == 0) parent[v] = v;
      int pu = find(u, parent);
      int pv = find(v, parent);
      if (pu == pv) {
        return edge;
      }
      if (size[pu] < size[pv]) {
        // 交换pu和pv指针位置
        int temp;
        temp = pu;
        pu = pv;
        pv = temp;
      }
      parent[pv] = pu;
      size[pu] += size[pv];
    }
    int[] res = new int[0];
    return res;

  }

  public int find(int node, int[] parent) {
    while (node != parent[node]) {
      parent[node] = parent[parent[node]];
      node = parent[node];
    }
    return node;
  }
}
