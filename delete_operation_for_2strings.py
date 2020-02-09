class Solution(object):
    def minDistance(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        
        if word1 == word2:
            return 0
        l1,l2 = len(word1), len(word2)
        dp = [[0 for _ in range(l2+1)] for _ in range(l1+1)]
        for i in range(1,l1+1):
            for j in range(1,l2+1):
                if word1[i-1] == word2[j-1]:
                    dp[i][j] = 1 + dp[i-1][j-1]
                else:
                    dp[i][j] = max(dp[i][j-1], dp[i-1][j])
        
        return l1 + l2 - 2 *(dp[-1][-1])