/*Solution: Use backTracking, but care for the visited index, remember to set the visited index to origin
* Time: O(m*n*3^word.length)
* Space: O(word.length)
*/
class Solution {
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (bfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(int i, int j, int curInd) {
        if (curInd == word.length()) {
            return true;
        }
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != word.charAt(curInd)) {
            return false;
        }
        board[i][j] = '#';
        if (bfs(i + 1, j, curInd + 1) || bfs(i - 1, j, curInd + 1) || bfs(i, j + 1, curInd + 1) || bfs(i, j - 1, curInd + 1)) {
            return true;
        }
        board[i][j] = word.charAt(curInd);
        return false;
    }
}