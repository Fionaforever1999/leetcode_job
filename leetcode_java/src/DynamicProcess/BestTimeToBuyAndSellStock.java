package DynamicProcess;

public class BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for (int i = 1; i < prices.length; i++) {
      int nums = prices[i] - prices[i - 1];
      maxCur += nums;
      maxCur = Math.max(0, maxCur);
      maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
  }
}
/**
 * kadane算法
 */
