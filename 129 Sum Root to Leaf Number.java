/*Solution: DFS
* Time: O(N)
* Space: O(logn)
*/
class Solution {
    private int curVal = 0;
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            res += curVal + root.val;
            return;
        }
        curVal += root.val;
        if (root.left != null) {
            curVal *= 10;
            helper(root.left);
            curVal /= 10;
        }
        if (root.right != null) {
            curVal *= 10;
            helper(root.right);
            curVal /= 10;
        }
    }
}