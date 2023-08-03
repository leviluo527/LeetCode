/*Solution: Bit manipulate, find the common 1's by shifting left
* Time: O(32)
* Space: O(1)
*/
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}