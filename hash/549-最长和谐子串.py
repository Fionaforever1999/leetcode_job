# 594. 最长和谐子序列
# 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。

# 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。

# 示例 1:

# 输入: [1,3,2,2,5,2,3,7]
# 输出: 5
# 原因: 最长的和谐数组是：[3,2,2,2,3].
class Solution:
    def findLHS(self, nums: List[int]) -> int:
        
        res = 0
        num = len(nums)
        for i in range(num):
            count = 0
            flag = False
            for j in range(num):
                if nums[i] == nums[j]:
                    count +=1
                elif nums[j]==nums[i]+1:
                    count += 1
                    flag = True
                if flag:
                    res = max(res, count)
        return res
class Solution:
    def findLHS(self, nums: List[int]) -> int:
        res = 0
        dict_num = {}
        for i in range(len(nums)):
            num = nums[i]
            if num not in dict_num:
                dict_num[num] = 1
            else:
                dict_num[num]+=1
        for key in dict_num:
            if key+1 in dict_num:
                res = max(res, dict_num[key]+ dict_num[key+1])
        return res