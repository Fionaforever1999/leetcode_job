class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        maxArea = 0
        dp = [[0] * len(matrix[0]) for _ in range(len(matrix))]
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == '0':
                    continue
                maxWidth = dp[row][col] = dp[row][col-1] + 1 if matrix[row][col] == "1" else 1

                for k in range(row, -1, -1):
                    # 表示从i往前倒数 一直到0
                    maxWidth = min(maxWidth, dp[k][col])
                    maxArea = max(maxArea, maxWidth*(row - k + 1))
        return maxArea