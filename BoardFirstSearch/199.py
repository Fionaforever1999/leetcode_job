# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
import collections
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        # 广度优先最后一个是右节点
        rightMost = {}
        queue = collections.deque([(root,0)])
        max_depth = -1
        while queue:
            node, depth = queue.popleft()
            if node is not None:
                max_depth = max(max_depth, depth)
                rightMost[depth] = node.val
                queue.append((node.left, depth+1))
                queue.append((node.right, depth+1))
        return [rightMost[depth] for depth in range(max_depth+1)]
