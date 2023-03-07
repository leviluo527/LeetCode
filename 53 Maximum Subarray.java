/*Solution: DP + Kadane's Algorithm
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(nums[i], res + nums[i]);
            max = Math.max(res, max);
        }
        return max;
    }
}