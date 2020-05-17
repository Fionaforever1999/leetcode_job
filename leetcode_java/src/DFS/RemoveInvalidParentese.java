//package DFS;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class RemoveInvalidParentese {
//  class Solution {
//    private Set<String> set = new HashSet<>();
//    private List<String> list = new ArrayList<>();
//
//    public List<String> removeInvalidParentheses(String s) {
//      set.add(s);
//      while (true) {
//        for (String s : set) {
//          if (isValid(s)) {
//            list.add(s);
//          }
//          if (list) return list;
//        }
//        Set<String> nextSet = new HashSet<>();
//        for (String s : set) {
//          for (int i = 0; i < s.length; i++) {
//            if (s[i] == '(' || s[i] == ')') nextSet.add(s.subString(0, i) + s.subString(i + 1, s.length));
//          }
//        }
//        set = nextSet;
//      }
//    }
//
//    public Boolean isValid(String str) {
//      int count = 0;
//      for (int i = 0; i < str.length; i++) {
//        if (str[i] == '(') count += 1;
//        if (str[i] == ')') count -= 1;
//        if (count < 0) return false;
//      }
//      return count == 0;
//    }
//
//  }
//}

