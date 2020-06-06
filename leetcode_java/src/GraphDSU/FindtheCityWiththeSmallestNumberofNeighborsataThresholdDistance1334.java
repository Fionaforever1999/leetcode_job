package GraphDSU;

import java.util.Arrays;

public class FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance1334 {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    // dijkstra
    // 任意两点之间的最短路径
    int[][] dp = new int[n][n];
    for (int i = 0; i < n; i++) {
      // 为什么 是最大值 / 2 因为后面执行相加操作 会爆掉
      Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
    }
    for (int[] e : edges) {
      // 定义循环
      dp[e[0]][e[1]] = e[2];
      dp[e[1]][e[0]] = e[2];

    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int m = 0; m < n; m++) {
          dp[j][m] = Math.min(dp[j][m], dp[j][i] + dp[i][m]);
        }
      }
    }
    // 最大的城市能够留下
    int ans = -1;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
      // 扫描起点
      int nb = 0;
      for (int j = 0; j < n; j++) {
        // 扫描终点
        if (i != j && dp[i][j] <= distanceThreshold) {
          nb++;
        }
      }
      if (nb <= min) {
        min = Math.min(nb, min);
        ans = i;
      }
    }
    return ans;
  }
}

