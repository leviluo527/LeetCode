/*Solution: Sorting
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public void wiggleSort(int[] nums) {
        boolean isSmall = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (isSmall && nums[i] < nums[i + 1]) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
            if (!isSmall && nums[i] > nums[i + 1]) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
            isSmall = !isSmall;
        }
    }
}