# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:return 0
        else :
            stack = [(1, root)]
            mindepth = float('inf')
        while stack:
            depth, root = stack.pop()
            children = [root.left, root.right]
            if not any(children):
                mindepth = min(depth, mindepth)
            for c in children:
                if c:
                    stack.append((depth+1, c))
        return mindepth