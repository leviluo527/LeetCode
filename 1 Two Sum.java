/*Solution1: Use a hashmap to find the result
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            //Since we don't allow an element to use twice
            //we need to check if 2 * nums[i] = target
            if (map.containsKey(remain) && map.get(remain) != i) {
                return new int[]{i, map.get(remain)};
            }
        }
        return new int[]{-1, -1};
    }
}

/*Solution2: Use one pass HashMap, everytime insert a value, we will look back
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}