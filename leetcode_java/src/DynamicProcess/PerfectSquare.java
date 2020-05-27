package DynamicProcess;

import java.util.Arrays;
import java.util.HashMap;

public class PerfectSquare {
  /**
   * dfs
   *
   * @param n
   * @return
   */
  public int numSquares(int n) {
    HashMap<Integer, Integer> map = new HashMap<>();
    return dfs(n, map);
  }

  public int dfs(int n, HashMap<Integer, Integer> map) {
    if (map.containsKey(n)) return map.get(n);
    if (n == 0) return 0;
    int count = Integer.MAX_VALUE;
    for (int i = 1; i * i <= n; i++) {
      count = Math.min(dfs(n - i * i, map) + 1, count);
    }
    map.put(n, count);
    return count;
  }

  /**
   *  动态规划 *********
   * @param n
   * @return
   */
  public int numSquaresII(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    // dp是前面的count计算了每一个值能够形成的最小完全square数解
    dp[0] = 0;// 初始值
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    return dp[n];
  }
}
