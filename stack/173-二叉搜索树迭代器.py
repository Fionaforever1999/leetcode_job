# 173. 二叉搜索树迭代器
# 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

# 调用 next() 将返回二叉搜索树中的下一个最小的数。

 

# 示例：



# BSTIterator iterator = new BSTIterator(root);
# iterator.next();    // 返回 3
# iterator.next();    // 返回 7
# iterator.hasNext(); // 返回 true
# iterator.next();    // 返回 9
# iterator.hasNext(); // 返回 true
# iterator.next();    // 返回 15
# iterator.hasNext(); // 返回 true
# iterator.next();    // 返回 20
# iterator.hasNext(); // 返回 false
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:
    # 解法1 扁平化二叉搜索树 
    def __init__(self, root: TreeNode):
        self.index = -1 # 为什么是-1
        self.ordered_list = [] # 一个数组用来存放 节点值 按照顺序排列
        self._inorder(root) # 中序遍历来获取所有node的值
    def _inorder(self, root):
        if not root:
            return 
        self._inorder(root.left)
        self.ordered_list.append(root.val)
        self._inorder(root.right)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        # index值自增1
        self.index += 1
        return self.ordered_list[self.index]

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.index + 1 < len(self.ordered_list)
        # 和之前的 self.index = -1 联系起来 因为从0开始 所以要找到下标需要-1 
        # 为了匹配长度需要对index + 1
        



# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
def __init__(self, root: TreeNode):
        self.stack = []
        self._leftmost_inorder(root)
    def _leftmost_inorder(self, root):
        while root:
            # 如果存在节点 入栈
            self.stack.append(root) 
            root = root.left
    def next(self) -> int:
        topmost = self.stack.pop()
        if topmost.right:
            # 如果存在右节点 对右节点进行操作
            self._leftmost_inorder(topmost.right)
        return topmost.val
    def hasNext(self) -> bool:
        return len(self.stack) > 0