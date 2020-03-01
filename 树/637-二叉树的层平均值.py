# 637. 二叉树的层平均值
# 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

# 示例 1:

# 输入:
#     3
#    / \
#   9  20
#     /  \
#    15   7
# 输出: [3, 14.5, 11]
# 解释:
# 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
# 注意：

# 节点值的范围在32位有符号整数范围内。
class Solution(object):
    def averageOfLevels(self, root):
        if not root:
            return []
        cur_layer = [root]
        res = []
        while cur_layer:
            a = 1.0*(sum(node.val for node in cur_layer) / len(cur_layer))
            res.append(a)
            next_layer = []
            for node in cur_layer:
                if node.left:
                    next_layer.append(node.left)
                if node.right:
                    next_layer.append(node.right)
            cur_layer = next_layer
        return res