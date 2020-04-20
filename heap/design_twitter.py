class Twitter:
    class Node:
        def __init__(self):
            self.followee = set()
            self.tweet = list()

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.time = 0
        self.recentMax = 10
        self.tweetTime = dict()
        self.user = dict()


        

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        if(userId not in self.user): # 将user设置为node节点里面存被关注者 和 所发的tweet
            self.user[userId] = Twitter.Node()
        self.user[userId].tweet.append(tweetId) # tweet记录这个用户所发的tweet的 tweetid
        self.time+=1 # 时间标记加1 全局变量记录 第几个时间
        self.tweetTime[tweetId] = self.time # 双向记录时间 tweettime 记录的是每个tweet所发出的时间

    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        if userId not in self.user:
            return []
        ans = self.user[userId].tweet[-10:][::-1]# [::-1]表示倒序输出 [-10:]表示倒数10个
        for followeeId in self.user[userId].followee:
            if followeeId in self.user:
                opt = self.user[followeeId].tweet[-10:][::-1]
                i, j, count = 0, 0, list()
                while i<len(ans) and j<len(opt):
                    if (self.tweetTime[ans[i]] < self.tweetTime[opt[j]]):
                        # 主用户发的时间小于从用户 从用户发的晚
                        count.append(opt[j])
                        j+=1
                    else:
                        count.append(ans[i])
                        i+=1
                count.extend(ans[i:])
                count.extend(opt[j:])# 当两个相加没有满足大于10条时
                ans = count[:10]
        return ans

        

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower(many) follows a followee（one）. If the operation is invalid, it should be a no-op.
        """
        if followeeId != followerId:
            if followerId not in self.user:
                # 没有userid就为这个关注者加node
                self.user[followerId] = Twitter.Node()
            self.user[followerId].followee.add(followeeId)


    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId != followeeId:
            if followerId in self.user:
                self.user[followerId].followee.discard(followeeId)
# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)