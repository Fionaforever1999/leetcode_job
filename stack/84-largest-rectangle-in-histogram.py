# 84. 柱状图中最大的矩形
# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

# 求在该柱状图中，能够勾勒出来的矩形的最大面积。

 



# 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

 



# 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

 

# 示例:

# 输入: [2,1,5,6,2,3]
# 输出: 10
class Solution:
    # 方法1 维护两个列表对每个heights[i] 的值的左右两边求面积
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        n = len(heights)
        res = 0  
        left = [0] * n # 左边的位置
        right = [n] * n # 右边的位置
        left[0] = -1
        right[-1] = n
        for i in range(1, n):
            tmp = i - 1
            while tmp>=0 and heights[i] <= heights[tmp]:
                tmp = left[tmp] # 相当于 left[i-1]的值赋给 tmp 
            left[i] = tmp # 获得 当前i下的 left值 是大于 heights[i] 的最大left长度
        for i in range(n-2, -1, -1):
            tmp = i + 1
            while tmp < n and heights[i] <= heights[tmp]:
                tmp = right[tmp]
            right[i] = tmp
        for i in range(n):
            res = max(res, (right[i] - left[i] -1) * heights[i])
        return res 

    # 方法2 利用栈的特性 如果heights[i]上升 入栈 否则出栈 ，出栈时持续计算面积 并存储面积
    # 直到面积值最大
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        heights = [0] + heights + [0]
        res = 0
        for i in range(len(heights)):
            #print(stack)
            while stack and heights[stack[-1]] > heights[i]:
                tmp = stack.pop()
                res = max(res, (i - stack[-1] - 1) * heights[tmp])
            stack.append(i)
        return res

