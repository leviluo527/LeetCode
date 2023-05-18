/*Solution: Recursive
* Time: O(N)
* Space: O(logN)
*/
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if (nums == null || nums.length == 0) {
            return root;
        }
        return BST(nums, 0, nums.length - 1);
    }

    private TreeNode BST(int[] nums, int left, int right) {
        if (left > right || left < 0 || right >= nums.length) {
            return null;
        }
        int mid = left + (right - left) / 2;
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = BST(nums, left, mid - 1);
        cur.right = BST(nums, mid + 1, right);
        return cur;
    }
}