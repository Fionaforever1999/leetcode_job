def pseudoPalindromicPaths(self, root: TreeNode) -> int:
        self.res = 0
        if not root:
            return 0

        # 把集合移入和移出操作提取出来, 简化代码
        def changeset(oddsets, v):
            if v in oddsets:
                oddsets.remove(v)
            else:
                oddsets.add(v)

        def dfs(node, oddsets):
            if not node.left and not node.right:
                # 叶子节点, 且奇数个数的元素数目不大于1就是满足条件的路径
                if len(oddsets) <= 1:
                    self.res += 1
                return
            if node.left:
                # 注意每次改变集合状态后, 在dfs遍历完要恢复成原始状态, 避免对后面的遍历产生影响, 下同
                changeset(oddsets, node.left.val)
                dfs(node.left, oddsets)
                changeset(oddsets, node.left.val)
            if node.right:
                changeset(oddsets, node.right.val)
                dfs(node.right, oddsets)
                changeset(oddsets, node.right.val)

        dfs(root, {root.val})
        return self.res

  