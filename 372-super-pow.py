# 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

# 示例 1:

# 输入: a = 2, b = [3]
# 输出: 8
# 示例 2:

# 输入: a = 2, b = [1,0]
# 输出: 1024
# 解题 https://mp.weixin.qq.com/s/GjS9ORJv3KtXEOU5WsyqYQ
class Solution(object):

    def mypow(self, a, k):
        base = 1337
        a%=base
        res = 1
        for i in range(k):
            res *= a
            res %= base
        return res
    def superPow(self, a, b):
        """
        :type a: int
        :type b: List[int]
        :rtype: int
        """
        base = 1337
        if not b:return 0
        res = 1
        for i in b:
            res = self.mypow(res,10) * self.mypow(a, i)
        return res % base
