/*Solution: Two for loop + Two sum two pointer
* Time: O(n^3)
* Space: O(n)
*/
class Solution {
    private Set<List<Integer>> set;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        set = new HashSet<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                twoSum(nums, i, j, target, res);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i, int j, int target, List<List<Integer>> res) {
        int l = j + 1;
        int r = nums.length - 1;
        //here we need to use long, since the -10^9 <= target <= 10^9
        long count = (long)target - nums[i] - nums[j];
        while (l < r) {
            if (nums[l] + nums[r] > count) {
                r--;
            } else if (nums[l] + nums[r] < count) {
                l++;
            } else {
                List<Integer> cur = new ArrayList<>();
                //Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                cur.add(nums[i]);
                cur.add(nums[j]);
                cur.add(nums[l]);
                cur.add(nums[r]);
                if (!set.contains(cur)) {
                    res.add(cur);
                    set.add(cur);
                }
                l++;
                r--;
            }
        }
    }
}