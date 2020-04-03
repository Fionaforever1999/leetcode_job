class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        dic = {}
        for num in nums:
            if num in dic:
                dic[num] += 1
                return True
            else:
                dic[num] = 1

        return False
        