/*Solution: Use result[] as a DP, dp[i] means product sum before i
* then start from right, num means product sum after i
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        //first start from left to right
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //right now res[i] means the every product sum before i
        int num = 1;
        //then start right to left, use num means every product sum after i
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * num;
            num *= nums[i];
        }
        return res;
    }
}