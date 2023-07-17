/*Solution: Use Recursion to DFS, for each node, we could save 
* node.val + left.val + right.val Or we could retrn node.val 
* + Max(left.val, right.val) to build a higher tree
* Time: O(N)
* Space: O(N)
*/
class Solution {
    private int maxRes = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxRes;
    }

    private int maxGain(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int leftVal = Math.max(maxGain(cur.left), 0);
        int rightVal = Math.max(maxGain(cur.right), 0);
        //save the max result that to let the node be the highest node
        maxRes = Math.max(maxRes, cur.val + leftVal + rightVal);
        //for recursion
        return cur.val + Math.max(leftVal, rightVal);
    }
}