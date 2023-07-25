/*Solution: Recursion
* Time: O(N)
* Space: O(logN)
*/
class Solution {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}