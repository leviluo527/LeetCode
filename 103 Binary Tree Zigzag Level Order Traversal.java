/*Solution: Use Deque to pollLast & offerFrist OR pollFirst & offerLast
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int level = 0;
        Deque<TreeNode> deq = new ArrayDeque<>();
        deq.offer(root);
        while (!deq.isEmpty()) {
            int size = deq.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (level == 0) {
                    //start from left
                    TreeNode curN = deq.pollFirst();
                    cur.add(curN.val);
                    if (curN.left != null) {
                        deq.offerLast(curN.left);
                    }
                    if (curN.right != null) {
                        deq.offerLast(curN.right);
                    }
                } else {
                    //start from right
                    TreeNode curN = deq.pollLast();
                    cur.add(curN.val);
                    if (curN.right != null) {
                        deq.offerFirst(curN.right);
                    }
                    if (curN.left != null) {
                        deq.offerFirst(curN.left);
                    }
                }
            }
            level = level == 0 ? 1 : 0;
            res.add(cur);
        }
        return res;
    }
}