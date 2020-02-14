class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        n = len(prices)
        dp = [[0]*3 for _ in range(n)]
        # dp[i][0] 表示未持有 dp[i][1]表示持有 dp[i][2]表示前一天卖出今日为冷冻期

        dp[0][0], dp[0][1], dp[0][2] = 0, -prices[0], 0
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][2]- prices[i])
            dp[i][2] = dp[i-1][0]
        print(dp)
        return max(dp[n-1][0], dp[n-1][2])

