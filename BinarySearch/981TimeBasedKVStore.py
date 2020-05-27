class TimeMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.t = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if  key not in self.t.keys():
            self.t[key] = [[timestamp, value]]
        else:
            self.t[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        # if not key: return ""
        # return self.t[k]
        data = self.t[key]
        if data[-1][0] <= timestamp:
            # 当所取时间戳 大于已经存入的时间戳 返回 当前时间戳
            return data[-1][1]
        if data[0][0] > timestamp:
            # 所取时间戳 小于最小的时间戳 说明不存在这个时间
            return ""
        if data[0][0] == timestamp:
            return data[0][1]
        lo, hi = 0, len(data) - 1
        while lo < hi:
            mid = (lo + hi) // 2
            if data[mid][0] > timestamp:
                hi = mid - 1
            else:lo = mid + 1
        return data[mid][1]



# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)