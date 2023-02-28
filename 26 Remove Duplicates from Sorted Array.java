/*Solution: Use fast & slow pointer
* Time: O(n)
* Space: O(1)
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                //add left first
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }
}