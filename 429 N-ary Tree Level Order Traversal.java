Two solutions:
1. Use Queue to BFS
2. Use recursion
/*Solution1: Use Queue to BFS
* Time: O(root.nodes)
* Space: O(max root lane)
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        //base case: if root is null, return empty list
        if (root == null) {
            return res;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curNode = q.poll();
                cur.add(curNode.val);
                for (Node child : curNode.children) {
                    q.offer(child);
                }
            }
            res.add(cur);
        }
        return res;
    }
}

/*Solution2: Use recursion
* Time: O(nodes)
* Space: O(log(nodes)), worst case: O(nodes)
*/
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            traverse(root, 0);
        }
        return res;
    }

    //use level to go to the correct List
    private void traverse(Node root, int level) {
        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        for (Node child : root.children) {
            traverse(child, level + 1);
        }
    }
}
