/*Solution: DFS
* Time: O(N!/(N - k)!)
* Space: O(N!)
*/
class Solution {
    private List<Integer> cur;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        cur = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    private void dfs(int[] nums, int ind, List<List<Integer>> res) {
        if (ind == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = ind; i < nums.length; i++) {
            swap(nums, i, ind);
            cur.add(nums[ind]);
            dfs(nums, ind + 1, res);
            swap(nums, i, ind);
            cur.remove(cur.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}