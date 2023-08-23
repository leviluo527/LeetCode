/*Solution: Binary Search
* Time: O(LogN)
* Space: O(1)
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return isBadVersion(left) ? left : right;
    }
}