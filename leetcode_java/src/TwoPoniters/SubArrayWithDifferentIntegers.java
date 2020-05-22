package TwoPoniters;

public class SubArrayWithDifferentIntegers {
  public int subarraysWithKDistinct(int[] A, int K) {
    return subArray(K, A) - subArray(K - 1, A);
  }

  public int subArray(int K, int[] A) {
    int[] count = new int[A.length + 1]; // count every different element show up times
    int ans = 0, i = 0; //  i is start index, j is end index
    // find a i to fullfill that the distinct numbers of integers in i->j is <=k
    for (int j = 0; j < A.length; j++) {
      if (count[A[j]]++ == 0) --K;// k is how many number we still could use
      while (K < 0) {
        // if k is too small remove i to larger k
        if (--count[A[i++]] == 0) ++K;
      }
      ans += j - i + 1;
    }
    return ans;
  }
}
