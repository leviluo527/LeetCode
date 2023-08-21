/*Solution1: Use another list to flattern the vector
* Time: O(N)
* Space: O(N)
*/
class Vector2D {
    private List<Integer> list;
    private int pointer;
    public Vector2D(int[][] vec) {
        pointer = 0;
        list = new ArrayList<>();
        for (int[] i : vec) {
            for (int j : i) {
                list.add(j);
            }
        }
    }
    
    public int next() {
        return list.get(pointer++);
    }
    
    public boolean hasNext() {
        return pointer < list.size();
    }
}
/*Solution2: skip the invalid vec[row]
* Time: O(Row)
* Space: O(1)
*/
class Vector2D {
    private int row;
    private int col;
    private int[][] vec;
    public Vector2D(int[][] vec) {
        row = 0;
        col = 0;
        this.vec = vec;
    }
    
    public int next() {
        skipInvalid();
        int cur = vec[row][col];
        col++;
        if (col >= vec[row].length) {
            row++;
            col = 0;
        }
        return cur;
    }
    
    public boolean hasNext() {
        skipInvalid();
        if (row >= vec.length) {
            return false;
        } else if (row == vec.length - 1 && col >= vec[row].length) {
            return false;
        }
        return true;
    }

    private void skipInvalid() {
        while (row < vec.length && (vec[row] == null || vec[row].length == 0)) {
            row++;
            col = 0;
        }
    }
}