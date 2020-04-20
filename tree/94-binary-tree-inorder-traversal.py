# # Definition for a binary tree node.
# # class TreeNode:
# 给定一个二叉树，返回它的中序 遍历。

# 示例:

# 输入: [1,null,2,3]
#    1
#     \
#      2
#     /
#    3

# 输出: [1,3,2]
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        l = []
        res = []
        while l or root:
            if root:
                l.append(root)
                root = root.left
            else:
                cur = l.pop()
                res.append(cur.val)
                root = cur.right
        return res