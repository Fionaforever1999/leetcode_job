# 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

# 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

# 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

# 示例 1:

# 输入: [2,4,1], k = 2
# 输出: 2
# 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
# 示例 2:

# 输入: [3,2,6,5,0,3], k = 2
# 输出: 7
# 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
#      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        if not prices or not k:
            return 0
        if k>len(prices)//2:
            return self.greedy(prices)
        dp, res = [[[0]*2 for _ in range(k+1)] for _ in range(len(prices))],[]
        
        for i in range(k+1):
            dp[0][i][0] = 0
            dp[0][i][1] = -prices[0]
        
        # k数值在第二维，第二维长度 k+1
        for i in range(1, len(prices)):
            for j in range(k+1):
                # 表示没有进行交易，所以保持上一次的值数
                if not j:
                    dp[i][j][0] = dp[i-1][j][0]
                else: 
                    
                    dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j-1][1] + prices[i])
                # 为什么用dp[i-1][j][0] - prices[i]而不是[j-1] 因为j+1的条件是卖出一次股票
                dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j][0] - prices[i])

        for m in range(k+1):
            res.append(dp[len(prices)-1][m][0])
        return max(res)
    def greedy(self, prices):
        res = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i-1]:
                res+=prices[i] - prices[i-1]
        return res