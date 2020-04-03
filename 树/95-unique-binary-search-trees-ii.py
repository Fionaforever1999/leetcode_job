# 95. 不同的二叉搜索树 II
# 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

# 示例:

# 输入: 3
# 输出:
# [
#   [1,null,3,2],
#   [3,2,null,1],
#   [3,1,null,null,2],
#   [2,1,3],
#   [1,null,2,null,3]
# ]
# 解释:
# 以上的输出对应以下 5 种不同结构的二叉搜索树：

#    1         3     3      2      1
#     \       /     /      / \      \
#      3     2     1      1   3      2
#     /     /       \                 \
#    2     1         2                 3
# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, x):
# #         self.val = x
# #         self.left = None
# #         self.right = None

class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        """
             生成树的节点 递归 
        """
        def generateTreesBy(start, end):
            if start>end:
                return [None,]
            all_tree = []
            for i in range(start, end+1):
                left = generateTreesBy(start, i-1)
                right = generateTreesBy(i+1, end)
                for l in left:
                    for r in right:
                        current_tree = TreeNode(i)
                        current_tree.left = l
                        current_tree.right = r
                        all_tree.append(current_tree)
            return all_tree
        return generateTreesBy(1,n) if n else []
            