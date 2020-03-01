# 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

# 说明：
# 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

# 示例 1:

# 输入: root = [3,1,4,null,2], k = 1
#    3
#   / \
#  1   4
#   \
#    2
# 输出: 1
# 示例 2:

# 输入: root = [5,3,6,2,4,null,null,1], k = 3
#        5
#       / \
#      3   6
#     / \
#    2   4
#   /
#  1
# 输出: 3

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:

    def kthSmallest(self, root: TreeNode, k: int) -> int:
        stack = []
        while True:
            while root:
               stack.append(root)
               root = root.left
            root = stack.pop()
            k -= 1
            if not k:
                return root.val
            root = root.right