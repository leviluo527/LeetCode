/*Solution1: Binary Search
* Time: O(logn)
* Space: O(1)
*/
class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x / 2;
        long num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            num = (long)mid * mid;
            if (num > x) {
                right = mid - 1;
            } else if (num < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}

/*Solution2: Newton's method
* Time: O(logn)
* Space: O(1)
*/
class Solution {
  public int mySqrt(int x) {
    if (x < 2) return x;

    double x0 = x;
    double x1 = (x0 + x / x0) / 2.0;
    while (Math.abs(x0 - x1) >= 1) {
      x0 = x1;
      x1 = (x0 + x / x0) / 2.0;
    }

    return (int)x1;
  }
}