/*Solution1: Recursive
* Time: O(N)
* Space: O(height)
*/
class Solution {
    private List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        inorder(root);
        return res;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }
}
/*Solution2: Use Stack to iterative
* Time: O(N)
* Space: O(logn)
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode helper = root;
        while (helper != null || !stack.isEmpty()) {
            if (helper!= null) {
                stack.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = stack.pollFirst();
                result.add(helper.val);
                helper = helper.right;
            }
        }
        return result;
    }
}