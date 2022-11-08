class Topological {
    public boolean topological (int N, int[][] array) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[N];
        for (int[] cur : array) {
          int start = cur[1];
          int end = cur[0];
          List<Integer> cur = graph.getOrDefault(start, new ArrayList<>());
          cur.add(end);
          indegree[start]++;
          graph.put(end, cur);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
          if (indegree[i] == 0) {
            q.offer(i);
          }
        }

        int count = 0;
        while (!q.isEmpty()) {
          int cur = q.poll();
          count++;
          for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
            if (--indegree[nei] == 0) {
              q.offer(nei);
            }
          }
        }
        return count == N;
    }
}
