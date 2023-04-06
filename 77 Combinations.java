/*Solution: DFS
* Time: O(n*k)
* Space: O(k)
*/
class Solution {
    private List<List<Integer>> res;
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        res = new ArrayList<>();
        helper(new ArrayList<>(), 1);
        return res;
    }

    private void helper(List<Integer> cur, int ind) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = ind; i <= n; i++) {
            cur.add(i);
            helper(cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}