/*Solution: Bianry Search
* Time: O(n^2)
* Space: O(LogN)
*/
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int left = j + 1;
                if (nums[i] + nums[j] + nums[left] >= target) {
                    continue;
                }
                int curTar = target - nums[i] - nums[j];
                int right = nums.length - 1;
                while (left < right - 1) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] >= curTar) {
                        right = mid - 1;
                    } else {
                        left = mid;
                    }
                }
                if (nums[right] < curTar) {
                    count += right - j;
                } else if (nums[left] < curTar) {
                    count += left - j;
                } else {
                    continue;
                }
            }
        }
        return count;
    }
}