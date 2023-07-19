/*Solution: Use Two pointer
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int curTar = 0;
        while (j < nums.length) {
            curTar += nums[j];
            while (curTar >= target) {
                min = Math.min(j - i + 1, min);
                curTar -= nums[i++];
            }
            j++;

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}