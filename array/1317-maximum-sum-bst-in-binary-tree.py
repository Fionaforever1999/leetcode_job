
# 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。

# 二叉搜索树的定义如下：

# 任意节点的左子树中的键值都 小于 此节点的键值。
# 任意节点的右子树中的键值都 大于 此节点的键值。
# 任意节点的左子树和右子树都是二叉搜索树。
 

# 示例 1：



# 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
# 输出：20
# 解释：键值为 3 的子树是和最大的二叉搜索树。
# 示例 2：



# 输入：root = [4,3,null,1,2]
# 输出：2
# 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
# 示例 3：

# 输入：root = [-4,-2,-5]
# 输出：0
# 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
# 示例 4：

# 输入：root = [2,1,3]
# 输出：6
# 示例 5：

# 输入：root = [5,4,8,3,null,6,3]
# 输出：7
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxSumBST(self, root: TreeNode) -> int:
        def BTS(node):
            if not node:return (1e9,-1e9,0, True)
            ll, lh, ls, lv = BTS(node.left)
            rl, rh, rs, rv = BTS(node.right)
            v = lv and rv and node.val >lh and node.val < rl
            s = node.val + ls + rs if v else -1
            self.ans = max(self.ans, s)
            return (min(ll, node.val), max(rh, node.val), s, v)
        self.ans = 0
        BTS(root)
        return self.ans


