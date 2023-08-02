/*Solution: Bit Manipulate, each loop n>>1, we just need to n & 1
* Time: O(32)
* Space: O(1)
*/
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int setter = 0;
        for (int i = 0; i < 32; i++) {
            setter <<= 1;
            if ((n & 1) == 1) {
                setter++;
            }
            n >>= 1;
        }
        return setter;
    }
}