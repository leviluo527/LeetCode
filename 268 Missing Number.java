/*Solution: Math
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int missingNumber(int[] nums) {
        int res = (1 + nums.length) * (nums.length) / 2;
        for (int i : nums) {
            res -= i;
        }       
        return res;
    }
}