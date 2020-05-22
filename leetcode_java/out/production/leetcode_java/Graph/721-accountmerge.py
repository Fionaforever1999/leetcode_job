class DSU:
    def __init__(self):
        self.parent = range(10001)
    def find(self, x):
        # 查找x的根节点
        if self.parent[x] !=x:
            # 当跟节点不是自己时 找到root 
            # 相当于进行了一次 path compression
            self.parent[x] = self.find(self.parent[x]);
        return self.parent[x]
    def union(self, x, y):
        # 将y的root设置为x的root
            self.parent[self.find(x)] = self.find(y)

            
class Solution:
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        dsu = DSU()
        emtoname = {}
        emtoidx = {}
        i = 0
        for account in accounts:
            #accounts = [["John", "johnsmith@mail.com", "john00@mail.com"],
            #["John", "johnnybravo@mail.com"], 
            #["John", "johnsmith@mail.com", "john_newyork@mail.com"],
            #["Mary", "mary@mail.com"]]
            # account ["John", "johnsmith@mail.com", "john00@mail.com"]
            name = account[0] 
            for email in account[1:]:
                # email  "johnsmith@mail.com", "john00@mail.com"
                emtoname[email] = name # {"johnsmith@mail.com": john}
                if email not in emtoidx:
                    emtoidx[email] = i; #{"johnsmith@mail.com" : 1}
                    i+=1;
                # 合并所有的在同一account下的节点 最后返回的是index 
                # 通过union方法能够将有两个相同元素的account的root合并 
                dsu.union(emtoidx[account[1]], emtoidx[email])
        ans = collections.defaultdict(list) # 字典中 key为 int value 为list
        for email in emtoname:
            # 找到email的root将email 的 root代表的index取出 加入当前email
            ans[dsu.find(emtoidx[email])].append(email)
        # print(ans)
        # {2: [u'johnsmith@mail.com', u'john00@mail.com', u'john_newyork@mail.com'], 3: [u'mary@mail.com'], 4: [u'johnnybravo@mail.com']}

        return [[emtoname[v[0]]] + sorted(v) for v in ans.values()]