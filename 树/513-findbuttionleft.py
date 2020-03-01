# 给定一个二叉树，在树的最后一行找到最左边的值。

# 示例 1:

# 输入:

#     2
#    / \
#   1   3

# 输出:
# 1
#  

# 示例 2:

# 输入:

#         1
#        / \
#       2   3
#      /   / \
#     4   5   6
#        /
#       7

# 输出:
# 7

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findBottomLeftValue(self, root: TreeNode) -> int:
        if not root:return -1
        d = collections.deque()
        d.append(root)
        while d:
            cur = d.popleft()
            if cur.right:
                d.append(cur.right)
            # print(d)
            if cur.left:
                d.append(cur.left)
            # print(d)
            
        return cur.val