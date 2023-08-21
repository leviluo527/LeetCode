/* Solution: DFS
* Time: O(N)
* Space: O(height)
*/
class Solution {
    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        helper(root, "");
        return res;
    }

    private void helper(TreeNode cur, String curString) {
        if (cur.left == null && cur.right == null) {
            curString += cur.val;
            res.add(curString);
            return;
        }
        curString += cur.val;
        curString += "->";
        if (cur.left != null) {
            helper(cur.left, curString);
        }
        if (cur.right != null) {
            helper(cur.right, curString);
        }
    }
}