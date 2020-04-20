class Solution:
    def maxSizeSlices(self, slices: List[int]) -> int:
        def calcualtion(s):
            n = len(s)
            num = (n + 1) // 3
            dp = [[0] * (num + 1) for _ in range (n + 1)]
            for i in range(1, n + 1):
                for j in range(1, num +1):
                    dp[i][j] = max((dp[i-2][j-1] if i-2>=0 else 0) +s[i-1], dp[i-1][j])
            return dp[n][num]
        
        front =  calcualtion(slices[1:])
        end = calcualtion(slices[:-1])
        return max(front, end)
