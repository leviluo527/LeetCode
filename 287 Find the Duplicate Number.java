/*Solution: Use Array as a HashMap
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }
}

/*Solution2: Since the number is from 1~n, use the nums[i] as the next index, 
* flip it to negatvie, if nums[nums[i]] is neg, means seen before 
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur] < 0) {
                duplicate = cur;
                break;
            }
            nums[cur] *= -1;
        }
        
        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }
}