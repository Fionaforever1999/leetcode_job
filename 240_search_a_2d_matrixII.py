class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix:return False
        for i in range(min(len(matrix[0]), len(matrix))):
            v = self.binarySearch(i, True, matrix, target)
            h = self.binarySearch(i,False, matrix, target)
            if v == True or h == True:
                return True
        return False
        
    
    def binarySearch(self, start, vertical, matrix, target):
        # vertial == True 表示 start是列

        low = i
        high = (len(matrix[0])-1 if vertical else len(matrix) - 1)
        while high >= low:
            mid = (high + low) / 2
            if vertical:
                if matrix[start][mid]>target:
                    high = mid - 1
                elif matrix[start][mid] <target:
                    low = mid + 1
                else:return True
            else:
                if matrix[mid][start] > target:
                    high = mid - 1
                elif matrix[mid][start] < target:
                    low = mid + 1
                else:return True
        return False
    