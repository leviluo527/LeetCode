/*Solution1: Use Math with iterative
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int missingElement(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return k;
        }
        int cur = nums[0];
        int i = 0;
        while (i < nums.length - 1) {
            int next = nums[i + 1];
            if (next - cur != 1) {
                if (next - cur - 1 < k) {
                    k = k - next + cur + 1;
                } else {
                    return cur + k;
                }
            } 
            i++;
            cur = next;
        }
        return cur + k;
    }
}

/*Solution2: Use Binary Search
* Time: O(logn)
* Space: O(1)
*/
class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                left = mid;
            } else{
                right = mid - 1;
            }
        }
        
        return nums[0] + k + left;
    }
}