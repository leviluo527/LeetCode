/*Solution: Use DFS to generate results
* Time: O(Nlogn)
* Space: O(Height)
*/
class Solution {
    private List<List<Integer>> res;
    private int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        helper(root.val, cur, root);
        return res;
    }

    private void helper(int curSum, List<Integer> cur, TreeNode curN) {
        if (curN.left == null && curN.right == null && curSum == targetSum) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (curN.left != null) {
            cur.add(curN.left.val);
            helper(curSum + curN.left.val, cur, curN.left);
            cur.remove(cur.size() - 1);
        }
        if (curN.right != null) {
            cur.add(curN.right.val);
            helper(curSum + curN.right.val, cur, curN.right);
            cur.remove(cur.size() - 1);
        }
    }
}