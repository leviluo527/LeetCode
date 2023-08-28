/*Solution: Bottom up DFS
* Time: O(N)
* Space: O(N)
*/
class Solution {
    private int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode p) {
        if (p == null) return 0;
        int L = dfs(p.left) + 1;
        int R = dfs(p.right) + 1;
        if (p.left != null && p.val + 1 != p.left.val) {
            L = 1;
        }
        if (p.right != null && p.val + 1 != p.right.val) {
            R = 1;
        }
        int length = Math.max(L, R);
        maxLength = Math.max(maxLength, length);
        return length;
    }
}