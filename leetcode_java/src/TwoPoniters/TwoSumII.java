package TwoPoniters;

public class TwoSumII {
  public int[] twoSumI(int[] numbers, int target) {
    int len = numbers.length;
    int[] ans = new int[2];
    int i = 0;
    for (; i < len; i++) {
      int j = i + 1;
      while (i < j && j < len) {
        if (numbers[i] + numbers[j] == target) {
          ans[0] = i + 1;
          ans[1] = j + 1;
        }
        j++;
      }
    }
    return ans;
  }

  public int[] twoSumII(int[] numbers, int target) {
    if (numbers == null) return null;
    int i = 0, j = numbers.length - 1;
    while (i < j) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[]{i + 1, j + 1};
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return null;
  }
}


