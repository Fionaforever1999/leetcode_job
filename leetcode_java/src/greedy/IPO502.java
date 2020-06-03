package greedy;

import java.util.PriorityQueue;

public class IPO502 {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
// 为了加快速度，首先检查是否存在所有项目都可投资且初始资本 W >= max(Capital) 的情况。如果是，返回利润中前 k 个最大元素的和。
    // 迭代选择 k 个项目，每一次选择：
    // 遍历 N 个项目，并在 W>=Capital[j] 的项目之间进行选择，选择 Profits[j] 最大的一个。
    // 如果当前资本不足以启动任意一个项目，则 break。
    // 更新 W += Profits[idx]，然后标记该项目启动资金为 Capital[j] = Integer.MAX_VALUE。
// 返回 W
    boolean speedUp = true;
    for (int i = 0; i < Capital.length; i++) {
      if (Capital[i] > W) speedUp = false;
    }
    if (speedUp) {
      PriorityQueue<Integer> queue = new PriorityQueue<>();
      for (int i : Profits) {
        queue.add(i);
        if (queue.size() > k)
          queue.poll();
      }
      for (int i : queue) {
        W += i;
      }
      return W;
    }
    int idx;
    for (int i = 0; i < Math.min(Profits.length, k); i++) {
      idx = -1;
      for (int j = 0; j < Profits.length; j++) {
        if (Capital[j] <= W) {
          if (idx == -1) idx = j;
          else if (Profits[idx] < Profits[j]) idx = j;
        }
      }
      if (idx == -1) break;
      W += Profits[idx];
      Capital[idx] = Integer.MAX_VALUE;
    }
    return W;
  }
}
