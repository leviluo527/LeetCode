/*Solution: Two Pointer
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public void moveZeroes(int[] nums) {
        //Two pointer
        // [0, i) -> not 0 [i, j) -> 0 [j, end] -> not figured 
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
            j++;
        }
        return;
    }
}