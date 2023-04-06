/*Solution: DFS, there are nums.length's level, each level have two option, add nums[ind] or not add
* Time: O(2^n)
* Space: O(N)
*/
class Solution {
    private List<List<Integer>> res;
    private int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        res = new ArrayList<>();
        helper(new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<Integer> cur, int ind) {
        if (ind == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        helper(cur, ind + 1);
        cur.add(nums[ind]);
        helper(cur, ind + 1);
        cur.remove(cur.size() - 1);
    }
}