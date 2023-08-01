/*Solution: Math problem
* Time: O(log5(n))
* Space: O(1)
*/
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}