package basic;

public class ZeroMatrix {
//    Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
//    column are set to 0. The items already set to 0 should not set entire row or column to 0.
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        ZeroMatrix r = new ZeroMatrix();
        r.zero(matrix);
    }

    private void zero(int[][] matrix) {
        // keep 2 arrays to store rows and columns with 0
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i=0;i<matrix.length;i++)
            for (int j=0;j<matrix[0].length;j++)
                if (matrix[i][j] == 0) {
                    rows[i] = true; // marking the rows touched
                    columns[j] = true; // marking the columns touched
                }
        // set marked rows as 0
        for (int i=0;i<rows.length;i++)
            if (rows[i])
                nullifyRow(matrix, i);
        // set marked columns to 0
        for (int j=0;j<columns.length;j++)
            if (columns[j])
                nullifyColumn(matrix, j);
    }

    private void nullifyRow(int[][] matrix, int num) {
        for (int i=0;i<matrix.length;i++) {
            matrix[num][i] = 0;
        }
    }
    private void nullifyColumn(int[][] matrix, int num) {
        for (int i=0;i<matrix.length;i++) {
            matrix[i][num] = 0;
        }
    }

    private void zero_adv(int[][] matrix) {
        //instead of keeping 2 arrays as above, first check if first row and first column of the matrix is to be set to zero or not
        // store it in boolean and use first row and first column to store the nullable rows and columns
        boolean nullify_first_row = false;
        boolean nullify_first_column = false;

        // Check if first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullify_first_row = true;
                break;
            }
        }

        // Check if first column has a zero
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][0] == 0) {
                nullify_first_column = true;
                break;
            }
        }

        for (int i=1;i<matrix.length;i++)
            for (int j=1;j<matrix[0].length;j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // marking the rows touched
                    matrix[0][j] = 0; // marking the columns touched
                }

        // set marked rows as 0
        for (int i=0;i<matrix.length;i++)
            if (matrix[i][0] == 0)
                nullifyRow(matrix, i);

        // set marked columns to 0
        for (int j=0;j<matrix[0].length;j++)
            if (matrix[0][j] == 0)
                nullifyColumn(matrix, j);

        // Nullify first row
        if (nullify_first_row)
            nullifyRow(matrix, 0);

        // Nullify first column
        if (nullify_first_column)
            nullifyColumn(matrix, 0);
    }
}
