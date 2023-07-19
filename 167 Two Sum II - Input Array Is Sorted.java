/*Solution: Use Two Pointer to maintain a window
* Time: O(N)
* Space: O(1)
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = 0;
        //First, find the right pointer that num[left] + num[right] are just bigger than target
        while (right < numbers.length && numbers[right] + numbers[left] <= target) {
            right++;
        }
        right -= 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}