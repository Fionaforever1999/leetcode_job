# 106. Construct Binary Tree from Inorder and Postorder Traversal
# Given inorder and postorder traversal of a tree, construct the binary tree.

# Note:
# You may assume that duplicates do not exist in the tree.

# For example, given

# inorder = [9,3,15,20,7]
# postorder = [9,15,7,20,3]
# Return the following binary tree:

#     3
#    / \
#   9  20
#     /  \
#    15   7
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        def helper(left_idx, right_idx):
            if left_idx > right_idx:
                return None
            if not postorder:
                return None
            val = postorder.pop()
            index = idx[val]
            val_node = TreeNode(val)
            # 先遍历右子树 后遍历左子树 因为后序遍历是左 -> 右 -> root 从右子树开始遍历 postorder pop的值就是右子树的根节点
            val_node.right = helper(index+1, right_idx)
            val_node.left = helper(left_idx, index-1)
            return val_node
        idx = {val: key for key, val in enumerate(inorder)} # 存储时 需要将索引存为value 值存为key
        return helper(0, len(inorder)-1)