# 二叉搜索树中的两个节点被错误地交换。

# 请在不改变其结构的情况下，恢复这棵树。

# 示例 1:

# 输入: [1,3,null,null,2]

#    1
#   /
#  3
#   \
#    2

# 输出: [3,1,null,null,2]

#    3
#   /
#  1
#   \
#    2
# 示例 2:

# 输入: [3,1,4,null,null,2]

#   3
#  / \
# 1   4
#    /
#   2

# 输出: [2,1,4,null,null,3]

#   2
#  / \
# 1   4
#    /
#   3

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 方法1 中序遍历
    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        x = y = pred = None
        stack = []
        while root or stack:
            while root: 
                stack.append(root)
                root = root.left
            root = stack.pop()
            if pred and root.val < pred.val:
                # 当前节点的值小于后面节点的值 中序遍历 说明需要交换前后节点
                y = root # 将要交换的节点存在y中
                if x is None:
                    x = pred
                else:break
            pred = root
            root = root.right
        x.val, y.val = y.val, x.val

    # 方法2 递归的中序遍历
    x = y = pred = None
        def find_Node(root: TreeNode):
            nonlocal x, y, pred # 设置非本地环境
            if root == None:
                return 
            find_Node(root.left)
            if pred and root.val < pred.val:
                y = root
                if x is None:
                    x = pred
                else:
                    return 
            pred = root
            find_Node(root.right)
        
        find_Node(root)
        x.val, y.val = y.val, x.val
    # 方法3 morris中序遍历
    # 如果没有链接，设置连接并走向左子树。
    # 如果有连接，断开连接并走向右子树。
    # 1， 根据当前节点，找到其前序节点，如果前序节点的右孩子是空，那么把前序节点的右孩子指向当前节点，然后进入当前节点的左孩子。
# 2， 如果当前节点的左孩子为空，打印当前节点，然后进入右孩子。
# 3，如果当前节点的前序节点其右孩子指向了它本身，那么把前序节点的右孩子设置为空，打印当前节点，然后进入右孩子
        x = y = pred = precursor =None
        
        while root:
            if root.left:
                precursor = root.left # 预先定义前驱节点
                while precursor.right and precursor.right != root:
                    precursor = precursor.right # 一路走到右子树最后
                # 有左节点 将前驱节点赋值为root
                if precursor.right is None:
                    precursor.right = root
                    root = root.left # 进行中序遍历
                else:
                    if pred and pred.val > root.val:
                        y = root
                        if x is  None:
                            x = pred
                    pred = root

                    precursor.right = None # 断开连接
                    root = root.right
            else:
                # 没有左子树 将前节点进行中序遍历
                if pred and pred.val > root.val:
                    y = root
                    if x is  None:
                        x = pred
                pred = root
                root = root.right
        x.val, y.val = y.val, x.val
 

