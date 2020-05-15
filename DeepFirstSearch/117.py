"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""
from collections import deque
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return root

        Q = collections.deque([root])
        while Q:
            size = len(Q)

            for i in range(size):
                node = Q.popleft() # 获得边上最右边的值
                if i <size -1:
                    node.next = Q[0] # 左边点的下一个值就是如Q的同一层的值
                if node.left:
                    Q.append(node.left)
                if node.right:
                    Q.append(node.right)
        return root