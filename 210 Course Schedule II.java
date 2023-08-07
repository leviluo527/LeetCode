/*Solution: Topological Sort
* Time: O(N)
* Space: O(N)
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] i : prerequisites) {
            int preC = i[1];
            int curC = i[0];
            indegree[curC]++;
            List<Integer> list = map.getOrDefault(preC, new ArrayList<>());
            list.add(curC);
            map.put(preC, list);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        if (q.isEmpty()) {
            return new int[]{};
        }
        int ind = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> list = map.getOrDefault(cur, new ArrayList<>());
            res[ind++] = cur;
            for (int i : list) {
                if (--indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return ind == numCourses ? res : new int[]{};
    }
}