package DynamicProcess;

public class BestTimeToBuyAndSellStock {
  /**
   * kadane 算法
   *
   * @param prices
   * @return
   */
  public int maxProfitI(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for (int i = 1; i < prices.length; i++) {
      int nums = prices[i] - prices[i - 1];
      maxCur += nums;
      maxCur = Math.max(0, maxCur);
      maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
  }


  /**
   * 双指针法
   * @param prices
   * @return
   */
  public int maxProfitII(int[] prices) {
    int maxProfit = 0;
    int buy = 0;
    int sell = 0;
    for (; sell < prices.length; sell++) {
      //当前价格更小了，更新 buy
      if (prices[sell] < prices[buy]) {
        buy = sell;
      } else {
        maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);

      }
    }
    return maxProfit;
  }
}
