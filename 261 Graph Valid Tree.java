/*Solution: Thought of Topological Sort
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] i : edges) {
            adjList.get(i[0]).add(i[1]);
            adjList.get(i[1]).add(i[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        q.offer(0);
        seen.add(0);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : adjList.get(cur)) {
                if (seen.contains(nei)) {
                    continue;
                }
                seen.add(nei);
                q.offer(nei);
            }
        }
        return seen.size() == n;
    }
}