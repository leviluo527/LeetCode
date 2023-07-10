/*Solution: in preorderIndex, we will know the root head, 
* therefore, we build a map for inorder to configure the left node and right node
* Time: O(N)
* Space: O(N)
*/
class Solution {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        //build a hashmap to store value
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        //if there are no element to construct the tree
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        //build left and right subtree recursivly
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootVal) + 1, right);
        return root;
    }
}