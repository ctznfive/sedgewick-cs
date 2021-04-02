public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int size = 0;
        int[][] s = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            s[0][i] = a[0][i];
            s[i][0] = a[i][0];
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i][j] == 1)
                    s[i][j] = Math.min(s[i][j - 1], Math.min(s[i - 1][j], s[i - 1][j - 1])) + 1;
                else
                    s[i][j] = 0;
            }
        }

        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[i][j] > size)
                    size = s[i][j];
            }
        }
        return size;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                a[i][j] = StdIn.readInt();
        }
        StdOut.println(size(a));
    }
}
