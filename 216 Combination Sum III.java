/*Solution: DFS
* Time: O(9!)
* Space: O(9)
*/
class Solution {
    private int k;
    private int n;
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        res = new ArrayList<>();
        if (k > n) {
            return res;
        }
        helper(new ArrayList<>(), 0, 1);
        return res;
    }

    private void helper(List<Integer> cur, int curSum, int ind) {
        if (cur.size() == k) {
            if (curSum == n) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = ind; i + curSum <= n && i <= 9; i++) {
            cur.add(i);
            helper(cur, curSum + i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}