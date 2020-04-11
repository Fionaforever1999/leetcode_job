class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        # 方法1 动态规划 暴力解
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
        
        
        # 方法2 动态规划 规定边界
        left = [0] * col
        right = [col] * col
        height = [0] * col
        maxArea = 0
        for i in range(row):
            
            cur_right = col
            cur_left = 0
            for j in range(col):
                if matrix[i][j] == '1':height[j] +=1
                else: height[j] = 0
            for j in range(col):
                if matrix[i][j] == '1':left[j] = max(left[j], cur_left)
                else:
                    left[j] = 0 # 遇到0 说明j列需要设置为0 边界为j+1
                    cur_left = j + 1
            for j in range(col-1, -1, -1): # 从列数的倒数来计算 省去后面加上1 计算面积的麻烦
                if matrix[i][j] == '1': right[j] = min(cur_right, right[j])
                else:
                    right[j] = col
                    cur_right = j-1
            for j in range(col):
                maxArea = max(maxArea, height[j] *(right[j] - left[j]))
        return maxArea
        
        
        #方法3 使用柱状图 栈 

    