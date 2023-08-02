/*Solution: DP
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2) {
                dp[i] = nums[i];
            } else if (i == 2) {
                dp[i] = nums[i] + dp[0];
            } else {
                dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}