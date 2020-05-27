class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        row = len(matrix)
        col = len(matrix[0])
        start = 0
        end = row * col -1
        while start <= end:
            # mid = start + (end - start) // 2
            mid = (start + end) /2
            if matrix[mid//col][mid%col] == target:
                return True
            elif matrix[mid//col][mid%col] > target:
                end = mid - 1
            else:
                start = mid + 1
        return False