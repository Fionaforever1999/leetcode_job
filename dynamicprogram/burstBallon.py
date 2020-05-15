#缓存机制保存 每次方法执行的结果
from functools import lru_cache 

class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        @lru_cache
        def dp(left, right):
            if left + 1 == right:return 0
            return max(nums[i]*nums[left]*nums[right] + dp(left, i) + dp(i, right) for i in range(left+1, right))
        return dp(0,len(nums)-1)    
