/*Solution: Use Two Pointer
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right--] = tmp;
                res++;
            } else {
                left++;
            }
        }
        return left;
    }
}