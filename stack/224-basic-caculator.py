# 224. Basic Calculator
# Implement a basic calculator to evaluate a simple expression string.

# The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

# Example 1:

# Input: "1 + 1"
# Output: 2
# Example 2:

# Input: " 2-1 + 2 "
# Output: 3
# Example 3:

# Input: "(1+(4+5+2)-3)+(6+8)"
# Output: 23
# Note:
# You may assume that the given expression is always valid.
# Do not use the eval built-in library function.

class Solution:
    def evaluate_exper(self, stack):
        res = stack.pop() if stack else 0

        # 计算表达式直到获得“）”
        while stack and stack[-1] != ')':
            sign = stack.pop()
            if sign == "+":
                res += stack.pop()
            else:
                res -= stack.pop()
        return res
    def calculate(self, s: str) -> int:
        stack = []
        operator, n = 0, 0
        for i in range(len(s)-1, -1, -1):
            # 没有将最后一个字符入栈 到最后需要将这个加上
            # 将s中的元素倒序入栈
            ch = s[i]
            if ch.isdigit():
                # 如果 s[i] 是数字 依旧是string类型
                operator = (10**n*int(ch)) + operator
                # 计数器加1
                n += 1
            elif ch != " ":
                # 当ch不等于空格的时候 分为两种情况 n 存在 将operator存入stack 
                if n:
                    stack.append(operator)
                    n, operator = 0, 0
                if ch =="(":
                    # 说明到了子表达式的开头 将之前的内容做计算
                    res = self.evaluate_exper(stack)
                    stack.pop()
                    # 替换stack中的内容
                    stack.append(res)
                    print(stack)
                # 其他非数字和表达式的入栈
                else:
                    stack.append(ch)
        if n:
            stack.append(operator)
        return self.evaluate_exper(stack)
        