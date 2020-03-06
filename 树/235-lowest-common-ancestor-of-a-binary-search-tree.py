# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        stack = []
        q_val = q.val
        p_val = p.val
        node = root
        while node:
            val = node.val
            if val < q_val and val < p_val:
                node = node.left
            elif val> q_val and val >p_val:
                node = node.right
            else:
                return node