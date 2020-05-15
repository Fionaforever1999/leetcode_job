# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        rightmost = dict()
        max_depth = -1 # ？
        stack = [(root,0)]
        while stack:
            #弹出栈顶 
            node, depth = stack.pop()
            if node is not None:
                max_depth = max(depth, max_depth)
                rightmost.setdefault(depth, node.val)  # 获取最右边的值， 深度优先每层的栈顶都是最右侧的元素
                stack.append([node.left,depth + 1])
                stack.append([node.right, depth + 1])
        return [rightmost[depth] for depth in range(max_depth+1)]