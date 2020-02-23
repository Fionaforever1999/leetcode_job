# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestUnivaluePath(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        def search(node):
            if node==None:return 0
            left = search(node.left)
            right = search(node.right)
            left_l, right_l = 0, 0
            if node.left and node.left.val ==node.val:
                left_l = left + 1
            if node.right and node.right.val == node.val:
                right_l = right +1
            self.ans = max(self.ans, left_l + right_l)
            return max(left_l, right_l)
        search(root)
        return self.ans
