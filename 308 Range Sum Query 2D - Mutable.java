class NumMatrix {
    private int rows;
    private int cols;
    private int[][] bit; // The BIT matrix

    private int lsb(int n) {
        // the line below allows us to directly capture the right most non-zero bit of a number
        return n & (-n);
    }

    private void updateBIT(int r, int c, int val) {
        // keep adding lsb(i) to i, lsb(j) to j and add val to bit[i][j]
        // Using two nested for loops, one for the rows and one for the columns
        for (int i = r; i <= rows; i += lsb(i)) {
            for (int j = c; j <= cols; j += lsb(j)) {
                this.bit[i][j] += val;
            }
        }
    }

    private int queryBIT(int r, int c) {
        int sum = 0;
        // keep subtracting lsb(i) to i, lsb(j) to j and obtain the final sum as the sum of non-overlapping sub-rectangles
        // Using two nested for loops, one for the rows and one for the columns
        for (int i = r; i > 0; i -= lsb(i)) {
            for (int j = c; j > 0; j -= lsb(j)) {
                sum += this.bit[i][j];
            }
        }
        return sum;
    }

    private void buildBIT(int[][] matrix) {
        for (int i = 1; i <= rows; ++i) {
            for (int j = 1; j <= cols; ++j) {
                // call update function on each of the entries present in the matrix
                int val = matrix[i - 1][j - 1];
                updateBIT(i, j, val);
            }
        }
    }

    public NumMatrix(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) return;
        cols = matrix[0].length;
        bit = new int[rows + 1][];
        // Using 1 based indexing, hence resizing the bit array to (rows + 1, cols + 1)
        for (int i = 1; i <= rows; ++i)
            bit[i] = new int[cols + 1];
        buildBIT(matrix);
    }

    public void update(int row, int col, int val) {
        int old_val = sumRegion(row, col, row, col);
        // handling 1-based indexing
        row++; col++;
        int diff = val - old_val;
        updateBIT(row, col, diff);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // handling 1-based indexing
        row1++; col1++; row2++; col2++;
        int a = queryBIT(row2, col2);
        int b = queryBIT(row1 - 1, col1 - 1);
        int c = queryBIT(row2, col1 - 1);
        int d = queryBIT(row1 - 1, col2);
        return (a + b) - (c + d);
    }
}