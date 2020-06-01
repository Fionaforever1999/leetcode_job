package BinarySearch;

public class POW {
  public double myPow(double x, int n) {
    long N = n;
    return N >= 0 ? quick(x, N) : 1.0 / quick(x, -N);
  }

  public double quick(double x, long n) {
    if (n == 0) return 1.0;
    double y = quick(x, n / 2);
    return n % 2 == 0 ? y * y : y * y * x;
  }
}
