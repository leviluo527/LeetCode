/*Solution: Use Two Pointer + Sorting
* Time: O(n^2)
* Space: O(logn)
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //diff means the difference between sum & target
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        //since we need to return the closest, we use target - diff = sum
        return target - diff;
    }
}