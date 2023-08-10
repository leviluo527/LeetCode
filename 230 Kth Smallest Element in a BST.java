/*Solution: Use Stack inorder to find k
* Time: O(H + K)
* Space: O(H)
*/
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //Use inorder traversal
        Stack<TreeNode> s = new Stack<>();
        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}