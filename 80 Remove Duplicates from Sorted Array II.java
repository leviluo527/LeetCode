/*Solution: Use fast slow pointer
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 1;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow] && nums[slow] == nums[slow - 1]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow + 1;
    }
}