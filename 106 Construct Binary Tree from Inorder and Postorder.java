/*Solution: Use the thought like merge sort, recursion
* Time: O(N)
* Space: O(N)
*/
class Solution {
    private int postOrderInd;
    private Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderInd = postorder.length - 1;
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return construct(0, inorder.length - 1, postorder);
    }

    private TreeNode construct(int left, int right, int[] postorder) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postOrderInd]);
        int curInd = inMap.get(postorder[postOrderInd--]);
        //we need to handle right first to prevent index out of bound -1
        root.right = construct(curInd + 1, right, postorder);
        root.left = construct(left, curInd - 1, postorder);
        return root;
    }
}