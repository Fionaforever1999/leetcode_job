package TwoPoniters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//https://leetcode.wang/leetCode-30-Substring-with-Concatenation-of-All-Words.html
public class SubstringwithConcatenationofAllWords30 {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    int wordNum = words.length;
    if (wordNum == 0) return res;
    int wordLen = words[0].length();

    // 用于存储所有子串
    HashMap<String, Integer> Allwords = new HashMap<>();

    for (String w : words) {
      int value = Allwords.getOrDefault(w, 0);
      Allwords.put(w, value + 1);
    }

    for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
      HashMap<String, Integer> hasWords = new HashMap<>();
      int num = 0;
      while (num < wordNum) {
        String temp = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
        if (Allwords.containsKey(temp)) {
          int value = hasWords.getOrDefault(temp, 0);
          hasWords.put(temp, value + 1);
          if (hasWords.get(temp) > Allwords.get(temp)) break;
        } else break;
        num++;
      }
      if (num == wordNum) res.add(i);
    }
    return res;
  }
}
