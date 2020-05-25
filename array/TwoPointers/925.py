class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        j = 0
        if typed[-1] != name[-1]: return False
        for c in name:        
            if len(typed)==j:
                return False
            if typed[j] != c:
                # typed 之前的值如果和现在不同 说明没有多按
                if j==0 or (typed[j-1] != typed[j]):
                    return False
                cur = typed[j]
                while j<len(typed) and typed[j] == cur:
                    j+=1
                if j==len(typed) or typed[j]!=c:
                    return False
            j+=1
                
        return True