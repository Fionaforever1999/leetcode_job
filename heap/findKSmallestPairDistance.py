class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        # nums.sort();
        # max_v = max(nums)
        # n = len(nums)
        # li = {i:0 for i in range(max_v+1)} 
        # # print(li)
        # for i in range(n):
        #     for j in range(i):
        #         li[nums[i] - nums[j]] +=1
        # # print(li)
        # for i in range(max_v):
        #     k-=li[i]
        #     if k < 0:
        #         return i
        # return 0
        n = len(nums)
        nums.sort()
        low = 0
        hei = nums[-1] - nums[0] #这个值是最大的差值
        
        while low < hei:
            count = 0
            j = 0
            m = low + (hei - low) // 2 #获取0和最大差值的中间值 以中间值为接线分pair
            for i in range(n):
                while nums[j] - nums[i] <= m and j <= n-1:
                    j += 1# 使j到达右边极值
                # 当获得的pair 在m之内 
                count += j-i-1
            if count >= k:
                hei = m - 1
            else:
                low = m + 1
        return low
                

     
