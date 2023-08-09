/*Solution: With conversion to long
* Time: O(32)
* Space: O(1)
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long)n;
        return (x & (x - 1)) == 0;
    }
}

/*Solution: Without conversion
* Time: O(32)
* Space: O(1)
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if ((n & 1) == 1) {
                return false;
            }
            n >>= 1;
        }
        return true;
    }
}