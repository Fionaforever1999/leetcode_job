package greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    Stack<Character> stack = new Stack<>();
    HashSet<Character> set = new HashSet<>();

    // get last occurnce
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!set.contains(c)) {
        // if the cur node is not contain in the
        while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > i) {
          set.remove(stack.pop());
        }
        set.add(c);
        stack.push(c);
      }

    }
    StringBuilder res = new StringBuilder(stack.size());
    for (Character c : stack) {
      res.append(c.charValue());
    }
    return res.toString();
  }
}
