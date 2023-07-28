/*Solution: Use multiple pointer, configure the conditions, when to switch neg and pos
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pos = 0;
        int neg = 0;
        int res = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > 0) {
                pos = pos == 0 ? i : pos * i;
                neg *= i;
            } else if (i == 0) {
                pos = 0;
                neg = 0;
            } else {
                int bpos = pos;
                pos = neg < 0 ? neg * i : 0;
                neg = bpos == 0 ? i : bpos * i;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}