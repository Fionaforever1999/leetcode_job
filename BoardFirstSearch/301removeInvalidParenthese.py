class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def isvalid(str):
            count = 0
            for i in str:
                if i=="(":
                    count +=1
                if i==")":
                    count-=1
                if count <0:return False # 如果循环中出现负值 需要跳出循环进入下一层

            return count==0

        level = {s}
        # 注意Python中定义set赋值方式

        while level:
            valid = list(filter(isvalid, level))
            if valid :return valid # 如果已经出现有效值说明已经找到最小的减去的括号数目

            next_level = set()
            for str in level:
                for i in range(len(str)):
                    if str[i] in "()":
                        next_level.add(str[:i] + str[i+1:])
            level = next_level              
