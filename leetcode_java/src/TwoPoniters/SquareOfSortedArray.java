package TwoPoniters;

public class SquareOfSortedArray {
  public int[] sortedSquares(int[] A) {
    int len = A.length;
    int i = 0, j = len - 1;
    int[] nums = new int[len--];
    while (j >= 0) {
      nums[j--] = A[i] * A[i] >= A[len] * A[len] ? A[i] * A[i++] : A[len] * A[len--];
    }
    return nums;
  }
}
