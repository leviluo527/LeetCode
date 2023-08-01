/*Solution1: Use inorder recursive
* Time: O(N)
* Space: O(1)
*/
class BSTIterator {
    private List<Integer> list;
    private int i;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        i = 0;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    public int next() {
        int val = list.get(i);
        i++;
        return val;
    }
    
    public boolean hasNext() {
        if (i >= list.size()) {
            return false;
        }
        return true;
    }
}

/*Solution2: Use Stack to control recursion
* Time: Amotize O(1)
* Space: O(N)
*/
class BSTIterator {
    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        leftMost(root);
    }
    
    private void leftMost(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode top = s.pop();
        if (top.right != null) {
            leftMost(top.right);
        }
        return top.val;
    }
    
    public boolean hasNext() {
        return !s.isEmpty();
    }
}