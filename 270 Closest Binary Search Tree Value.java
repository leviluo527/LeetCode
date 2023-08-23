/*Solution: Iterative
* Time: O(height)
* Space: O(1)
*/
class Solution {
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs((double)cur.val - target) == Math.abs((double)closest - target)) {
                closest = Math.min(cur.val, closest);
            } else {
                closest = Math.abs((double)cur.val - target) < Math.abs((double)closest - target) ? cur.val : closest;
            }
            if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return closest;

    }
}