# 316. Remove Duplicate Letters
# Given a string which contains only lowercase letters, 
# remove duplicate letters so that every letter appears once and only once. 
# You must make sure your result is the smallest in lexicographical order among
#  all possible results.

# Example 1:

# Input: "bcabc"
# Output: "abc"
# Example 2:

# Input: "cbacdcbc"
# Output: "acdb"
# Note: This question is the same as 
# 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
class Solution:
    from collections import Counter 
    def removeDuplicateLetters(self, s: str) -> str:
        # lexicographical 字典
        count = Counter(s)
        n = len(s)
        pos = 0
        for i in range(n):
            if s[i] < s[pos]: pos = i
            
            count[s[i]] -= 1
            if count[s[i]] == 0:
                break
        return s[pos] + self.removeDuplicateLetters(s[pos:].replace(s[pos], '')) if s else ''