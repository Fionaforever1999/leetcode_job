package Tree;

import java.util.HashMap;

public class MinimumWindowSubstring76 {
  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;

    int ansL = 0;
    int ansR = -1;
    int ansLen = Integer.MAX_VALUE;
    for (int i = 0; i < t.length(); i++) {
      char tv = t.charAt(i);
      map.put(tv, map.getOrDefault(tv, 0) + 1);
    }
    while (right < s.length()) {
      char charR = s.charAt(right);
      if (map.containsKey(charR)) {
        map.put(charR, map.get(charR) - 1);
        while (match(map)) {// while every element match the sequence
          int temp = right - left + 1;
          if (temp < ansLen) {
            ansL = left;
            ansR = right;
            ansLen = temp;
          }
          char charL = s.charAt(left);
          if (map.containsKey(charL)) {
            map.put(charL, map.get(charL) + 1);
          }
          left++;
        }
      }
      right++;
    }
    return s.substring(ansL, ansR + 1); // 取前不取后
  }

  public boolean match(HashMap<Character, Integer> map) {
    for (int n : map.values()) {
      if (n > 0) return false;
    }
    return true;
  }
}
