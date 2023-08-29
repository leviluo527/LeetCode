/*Solution: Easy
* Time: O(N* N)
* Space: O(1)
*/
class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int res = 0;
        while (left <= right) {
            res += nums[left];
            left++;
        }
        return res;
    }
}

/*Solution2: nums[i] = sum from 0 to i
* Time: Amotize O(n)
* Space: O(1)
*/
class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return nums[right];
        }
        return nums[right] - nums[left - 1];
    }
}