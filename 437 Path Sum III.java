/*Solution: Use dfs recursion + prefix sum HashMap
* Remeber to delete the sum before
* Time: O(N)
* Space: O(logN) not count the hashmap, O(N) count the hashmap
*/
class Solution {
    //make count to global variable, we don't need to return value in preOrder
    private int count = 0;
    private int targetSum;
    //Use long is because the roots.val in this problem is -10^9< val <10^9
    private HashMap<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        preOrder(root, 0L);
        return count;
    }

    private void preOrder(TreeNode cur, long curSum) {
        if (cur == null) {
            return;
        }
        curSum += cur.val;
        //first we check, if the curSum from root to cur is equal to targetSum
        if (curSum == targetSum) {
            count++;
        }
        //Check if contains any solutions
        count += map.getOrdefault(curSum - targetSum, 0);
        //put the prefix sum in the Map
        map.put(curSum, map.getOrdefault(curSum, 0) + 1);

        preOrder(cur.left, curSum);
        preOrder(cur.right, curSum);
        map.put(curSum, map.get(curSum) - 1);
    }
}
