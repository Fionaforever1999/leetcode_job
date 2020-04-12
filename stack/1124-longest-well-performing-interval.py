# 1124. Longest Well-Performing Interval
# We are given hours, a list of the number of hours worked per day for a given employee.

# A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

# A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

# Return the length of the longest well-performing interval.

 

# Example 1:

# Input: hours = [9,9,6,0,6,6,9]
# Output: 3
# Explanation: The longest well-performing interval is [9,9,6].
 

# Constraints:

# 1 <= hours.length <= 10000
# 0 <= hours[i] <= 16
# 解法 单调栈以及
class Solution:
    def longestWPI(self, hours: List[int]) -> int:
        score = [0] * len(hours)
        for i in range(len(hours)):
            if hours[i] >8:
               score[i] = 1
            else: score[i] = -1
            # score的值就是1 或者 -1
        presum = [0] *(len(hours) + 1)
        for i in range(1, len(presum)):
            presum[i] = score[i-1] + presum[i-1]
            # 得到presum就是将每个score的值与之前的值相加
        stack = []        
        for j in range(len(presum)):
            if not stack or presum[j]<presum[stack[-1]]:
                stack.append(j) # 将字典中的内容降序入栈
        # 倒序扫描数组

        i = len(hours)
        while ans<i:
            while stack and  presum[i]>presum[stack[-1]]:
                ans = max(ans, i - stack.pop())
            i-=1
        return ans 