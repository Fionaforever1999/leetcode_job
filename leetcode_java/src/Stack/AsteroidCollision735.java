package Stack;

import java.util.Stack;

public class AsteroidCollision735 {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    for (int ast : asteroids) {
      collection:
      {
        while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
          if (stack.peek() < -ast) {
            stack.pop();
            continue;
          } else if (stack.peek() == -ast) {
            stack.pop();
          }
          break collection;
        }
        stack.push(ast);
      }
    }
    int ans[] = new int[stack.size()];
    for (int i = ans.length - 1; i >= 0; i--) {
      ans[i] = stack.pop();
    }
    return ans;

  }
}
