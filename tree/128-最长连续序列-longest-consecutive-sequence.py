# 给定一个未排序的整数数组，找出最长连续序列的长度。

# 要求算法的时间复杂度为 O(n)。**************

# 示例:

# 输入: [100, 4, 200, 1, 3, 2]
# 输出: 4
# 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # 暴力解法
        long_stack = 0
        for num in nums:
            cur = num
            curr_stack = 1
            while cur+1 in nums:
                cur+=1
                curr_stack +=1     
            long_stack = max(long_stack, curr_stack)
        return long_stack
 # 排序
        if nums==[]:
            return 0
        nums.sort()
        long_stack = 1
        curr_stack = 1
        for i in range(1, len(nums)):
            if nums[i]!= nums[i-1]:
                if nums[i] == nums[i-1] + 1:
                    curr_stack +=1
                else:
                    long_stack = max(curr_stack,long_stack)
                    curr_stack = 1
     # 当循环没有进行到else的时候会直接输出当前cur但是不是最长 所以要把最长作为return 输出
        return  max(curr_stack,long_stack)
       # 哈希映射
        long_streak = 0
        num_set = set(nums)
        for num in num_set:
            if num -1 not in num_set:
                cur = num
                cur_streak = 1
                while cur+1 in num_set:
                    cur += 1
                    cur_streak += 1
                long_streak = max(cur_streak,long_streak)
        return long_streak 
