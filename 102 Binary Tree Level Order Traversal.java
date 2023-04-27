/*Solution: Use Queue to BFS
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = q.poll();
                cur.add(curNode.val);
                if (curNode.left != null) {
                    q.add(curNode.left);
                }
                if (curNode.right != null) {
                    q.add(curNode.right);
                }
            }
            res.add(cur);
        }
        return res;
    }
}