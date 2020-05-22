package TwoPoniters;

public class ValidPanlindrome {
  public boolean isPalindrome(String s) {
    int len = s.length();
    s = s.toLowerCase();
    int i = 0, j = len - 1;
    while (i < j) {
      while (!isAlphanumeric(s.charAt(i))) {
        // when s[i] is not numberic we jump to next
        i++;
        // if s=='  '  return true because there is no alphanumberic
        if (i == len) return true;
      }
      while (!isAlphanumeric(s.charAt(j))) {
        j--;
      }
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private boolean isAlphanumeric(char c) {
    if ('a' <= c && 'z' >= c || 'A' <= c && 'Z' >= c || '0' <= c && '9' >= c) {
      return true;
    }
    return false;
  }
}
