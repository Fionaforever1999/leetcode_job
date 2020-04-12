# 962. 最大宽度坡
# 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。

# 找出 A 中的坡的最大宽度，如果不存在，返回 0 。

 

# 示例 1：

# 输入：[6,0,8,2,1,5]
# 输出：4
# 解释：
# 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
# 示例 2：

# 输入：[9,8,1,0,1,9,4,0,4,1]
# 输出：7
# 解释：
# 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 

# 提示：

# 2 <= A.length <= 50000
# 0 <= A[i] <= 50000
class Solution:
    def maxWidthRamp(self, A: List[int]) -> int:
        # 方法1 利用sorted方法做 将数组按照值的内容排列下标 升序排列 找到最小的下标差
        m = float("inf")
        ans = 0
        for i in sorted(range(len(A)), key = A.__getitem__):
            ans = max(ans, i-m)
            m = min(i,m)
        return ans
        # 方法2 单调递减栈
         stack = []
        ans = 0
        for i in range(len(A)):
            if len(stack) == 0 or A[i]< A[stack[-1]]:
                # 如果stack值为0 说明还未入栈
                # 记录一些较小值的下标 保证栈中存储的递减的A中数字的下标
                stack.append(i) 
        # j = len(A)-1
        # while j > ans:
        for j in range(len(A) - 1,ans - 1, -1):
            while stack and A[j]>=A[stack[-1]]:
                # stack的存在性要安排在A的运算之前
                ans = max(ans, j - stack.pop()) 
        return ans
        