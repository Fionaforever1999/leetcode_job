# 98. 验证二叉搜索树
# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

# 假设一个二叉搜索树具有如下特征：

# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
# 示例 1:

# 输入:
#     2
#    / \
#   1   3
# 输出: true
# 示例 2:

# 输入:
#     5
#    / \
#   1   4
#      / \
#     3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
#      根节点的值为 5 ，但是其右子节点值为 4 。

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    #递归
    def isValidBST(self, root: TreeNode) -> bool:
        def helper(root, min_v=float("-inf"), max_v=float("inf")):
            if not root: return True
            val = root.val
            if val >= max_v or val <= min_v:
                return False
            if not helper(root.left, min_v, val):
                return False
            if not helper(root.right, val, max_v):
                return False
            # 需要在这里加上return True因为 如果一直递归执行 会returnFalse 
            return True 
            
        return helper(root)
    # 或者
     def isValidBST(self, root: TreeNode) -> bool:
        def helper(root, min_v=float("-inf"), max_v=float("inf")):
            if not root: return True
            val = root.val
            if val >= max_v or val <= min_v:
                return False

            return helper(root.left, min_v, val) and helper(root.right, val, max_v)
        return helper(root)
    # 解法二中序遍历 二叉搜索树按顺序排列
      def isValidBST(self, root: TreeNode) -> bool:
        inOrder = float("-inf")
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= inOrder:
                return False
            inOrder = root.val
            root = root.right
        return True


