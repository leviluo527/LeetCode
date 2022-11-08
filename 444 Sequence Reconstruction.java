/*Solution: Use Topological sort, but the queue should have only one node inside
* Time: O(seq.size() * seq.get(0).size())
* Space: O(nums.length)
*/
class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indeg = new HashMap<>();
        for (List<Integer> seq : sequences) {
            if (seq.size() == 1) {
                if (!map.containsKey(seq.get(0))) {
                    map.put(seq.get(0), new HashSet<>());
                    indeg.put(seq.get(0), 0);
                }
            } else {
                for (int i = 0; i < seq.size() - 1; i++) {
                    if (!map.containsKey(seq.get(i))) {
                        map.put(seq.get(i), new HashSet<>());
                        indeg.put(seq.get(i), 0);
                    }
                    if (!map.containsKey(seq.get(i + 1))) {
                        map.put(seq.get(i + 1), new HashSet<>());
                        indeg.put(seq.get(i + 1), 0);
                    }
                    if (map.get(seq.get(i)).add(seq.get(i + 1))) {
                        indeg.put(seq.get(i + 1), indeg.get(seq.get(i + 1)) + 1);
                    }
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : indeg.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        int ind = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (size > 1) {
                return false;
            }
            int cur = q.poll();
            if (ind == nums.length || cur != nums[ind++]) {
                return false;
            }
            for (int nxt : map.get(cur)) {
                indeg.put(nxt, indeg.get(nxt) - 1);
                if (indeg.get(nxt) == 0) {
                    q.offer(nxt);
                }
            }
        }
        return ind == nums.length && ind == map.size();
    }
}
