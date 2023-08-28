/*Solution: Use a Queue to se and dese
* Time: O(N)
* Space: O(N)
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static String NULL = "NULL";
    private static String SP = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                res.append(NULL);
                res.append(SP);
            } else {
                res.append(cur.val);
                res.append(SP);
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] tokens = data.split(SP);
        TreeNode root = new TreeNode(Integer.valueOf(tokens[0]));
        int i = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty() && i < tokens.length) {
            TreeNode cur = q.poll();
            if (!tokens[i].equals(NULL)) {
                TreeNode leftNode = new TreeNode(Integer.valueOf(tokens[i]));
                cur.left = leftNode;
                q.offer(leftNode);
            }
            i++;
            if (!tokens[i].equals(NULL)) {
                TreeNode rightNode = new TreeNode(Integer.valueOf(tokens[i]));
                cur.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));