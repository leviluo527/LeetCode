/*Solution: Use DFS + Sorting to ignore duplicates
* Time: O(N*2^n)
* Space: O(N)
*/
class Solution {
    List<List<Integer>> res;
    List<Integer> cur;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        cur = new ArrayList<>();
        helper(nums, cur, 0);
        return res;
    }

    private void helper(int[] nums, List<Integer> cur, int ind) {
        res.add(new ArrayList<>(cur));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.add(nums[i]);
            helper(nums, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}