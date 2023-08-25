/*Solution: BFS
* Time: O(M^2 * N^2)
* Space: O(MN)
*/
class Solution {
    private int row;
    private int col;
    private int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        row = rooms.length;
        col = rooms[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        int len = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int curI = cur[0];
                int curJ = cur[1];
                if (curI > 0 && rooms[curI - 1][curJ] != -1 && rooms[curI - 1][curJ] > len) {
                    rooms[curI - 1][curJ] = len;
                    q.offer(new int[]{curI - 1, curJ});
                }
                if (curI < row - 1 && rooms[curI + 1][curJ] != -1 && rooms[curI + 1][curJ] > len) {
                    rooms[curI + 1][curJ] = len;
                    q.offer(new int[]{curI + 1, curJ});
                }
                if (curJ > 0 && rooms[curI][curJ - 1] != -1 && rooms[curI][curJ - 1] > len) {
                    rooms[curI][curJ - 1] = len;
                    q.offer(new int[]{curI, curJ - 1});
                }
                if (curJ < col - 1 && rooms[curI][curJ + 1] != -1 && rooms[curI][curJ + 1] > len) {
                    rooms[curI][curJ + 1] = len;
                    q.offer(new int[]{curI, curJ + 1});
                }
            }
            len++;
        }
    }
}