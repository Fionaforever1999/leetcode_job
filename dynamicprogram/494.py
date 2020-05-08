class Solution:
    def findTargetSumWays(self, nums, S):

        if sum(nums) < S:
            return 0
        sums = sum(nums)
        n = len(nums)
        ways = [[0] * (sums*2+1)] * (n+1)
        ways[0][sums] = 1 #  表示第0行在sum值处出现了1次 即在等于0的位置设为1
        for i in range(1,n):
            for j in range(nums[i], 2*sums+1-nums[i]):
                if ways[i][j]:
                    ways[i+1][j + nums[i]] += ways[i][j]
                    ways[i+1][j - nums[i]] += ways[i][j]
                
        print(ways)
        return ways[S+sums]
if __name__ == "__main__":
    A = Solution()
    A.findTargetSumWays([1,1,1,1,1],3)