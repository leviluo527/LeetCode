/*Solution: Topological Sort
* Use a indgree[] to count the course nums of the i'th course need
* Then use a course map to save the list of prerequisite course
* Use a Queue to check loop and the course with no preRequisite
* for each layer of BFS, means a course to take
* Time: O(m + n)
* Space: O(m + n)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> course = new HashMap<>();
        int[] indgree = new int[numCourses];
        for (int[] i : prerequisites) {
            int start = i[0];
            int pre = i[1];
            List<Integer> cur = course.getOrDefault(pre, new ArrayList<>());
            cur.add(start);
            indgree[start]++;
            course.put(pre, cur);
        }
        Queue<Integer> q = new ArrayDeque<>();
        //add the courses that don't need prerequisites to the Queue
        for (int i = 0; i < indgree.length; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }
        //if there are no courses need prerequisites, means there is a loop
        if (q.isEmpty()) {
            return false;
        }
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            //Since the cur course may not in the map, here need to use getOrDefault
            List<Integer> courseList = course.getOrDefault(cur, new ArrayList<>());
            for (int c : courseList) {
                if (--indgree[c] == 0) {
                    q.offer(c);
                }
            }
            count++;
            if (count > numCourses) {
                return false;
            }
        }
        return count == numCourses;
    }
}