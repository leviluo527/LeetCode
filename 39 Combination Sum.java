/*Solution: DFS, use ind as i pointer
* Time: O(N ^ (T / M) + 1)
* Space: O(target val / minimal value among the candidates)
*/
class Solution {
    private List<List<Integer>> res;
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        this.target = target;
        dfs(new ArrayList<>(), candidates, 0, 0);
        return res;
    }

    private void dfs(List<Integer> cur, int[] candidates, int curVal, int ind) {
        if (curVal == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (curVal > target) {
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            cur.add(candidates[i]);
            dfs(cur, candidates, curVal + candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}