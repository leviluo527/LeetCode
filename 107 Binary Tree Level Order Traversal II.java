/*Solution: Use a queue to level order, Use stack to save each level result and reverse
* Time: O(N)
* Space: o(2N)
*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                cur.add(curNode.val);
                if (curNode.left != null) {
                    q.offer(curNode.left);
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                }
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            res.add(stack.poll());
        }
        return res;
    }
}