# 计算给定二叉树的所有左叶子之和。

# 示例：

#     3
#    / \
#   9  20
#     /  \
#    15   7

# 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root :
            return 0
        if root.left and not (root.left.left or root.left.right):
            return root.left.val + self.sumOfLeftLeaves(root.right)
        return self.sumOfLeftLeaves(root.right) + self.sumOfLeftLeaves(root.left)

    def sumOfLeftLeaves(self, root):
        # 方法二 先序遍历采用迭代法， 判断当前节点是否是左叶子节点 
        sum_ = 0
        ans = [root]
        while ans:
            if root.left and not (root.left.left or root.left.right):
                sum_ += root.left
            if root.left:
                ans.append(root.left)
            if root.right:
                ans.append(root.right)
        return sum_