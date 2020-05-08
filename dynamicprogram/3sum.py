class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        if n<3:
            return []
        res = []
        nums.sort()
        for i in range(n):
            if nums[i] >0:
                return res
            if (i>0 and nums[i] == nums[i-1]):
                continue
            L = i + 1
            R = n-1
            while L<R:
                if nums[L] + nums[i] + nums[R] == 0:
                    res.append([nums[L], nums[i], nums[R]])
                    while L<R and nums[L] == nums[L+1]:
                        L +=1
                    while L<R and nums[R] == nums[R - 1]:
                        R-=1
                    L+=1
                    R-=1
                elif nums[L] + nums[i] + nums[R] > 0:
                    R -= 1
                else:
                    L += 1
        return res


                
