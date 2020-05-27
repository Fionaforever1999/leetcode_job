class Solution:
    def shipWithinDays(self, weights: List[int], D: int) -> int:
        lo = max(weights)
        hi = sum(weights)
        while(lo < hi):
            mid = (lo + hi) // 2
            if  self.possible(mid,weights, D):
                hi = mid
            else:lo = mid +1
        return lo
    def possible(self,mid,weights,D):
        temp = 0
        day = 1
        for i in range(len(weights)):
            temp += weights[i]
            if(temp > mid):
                day += 1
                temp = weights[i]

        return day <=D