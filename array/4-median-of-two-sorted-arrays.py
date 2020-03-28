# 4. 寻找两个有序数组的中位数
# 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

# 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

# 你可以假设 nums1 和 nums2 不会同时为空。

# 示例 1:

# nums1 = [1, 3]
# nums2 = [2]

# 则中位数是 2.0
# 示例 2:

# nums1 = [1, 2]
# nums2 = [3, 4]

# 则中位数是 (2 + 3)/2 = 2.5
class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        m = len(nums1)
        n = len(nums2)
        A, B = nums1, nums2
        if m>n:
            A, B, m, n = B, A, n, m 
        half_len = (m + n + 1)//2
        imin = 0
        imax = m
        while imin <= imax:
            i = (imin + imax)//2
            j = half_len - i
            if i < m and A[i]<B[j-1]:
                # 说明i太小
                imin = i + 1
            elif i>0 and  A[i-1] > B[j]:
                # 说明i太大
                imax = i-1
            else:
                # 说明找到合适的i
                if i==0:max_left = B[j-1]
                elif j==0:max_left=A[i-1]
                else:max_left=max(B[j-1], A[i-1])
                if (m+n)%2==1:
                    return max_left
                if i==m: min_right = B[j]
                elif j==n: min_right=A[i]
                else:min_right = min(A[i], B[j])
                return (min_right+max_left)/2