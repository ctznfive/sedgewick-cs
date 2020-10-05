public class TrinomialDP {

    // Returns the trinomial coefficient coef(n, k).
    public static long trinomial(int n, int k) {
        if (k < -n || k > n) return 0;
        if (n == 0 && k == 0) return 1;

        long[][] coef = new long[n + 1][n + 1];
        coef[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == n) coef[i][j] = coef[i - 1][j - 1];
                else coef[i][j] = coef[i - 1][Math.abs(j - 1)] + coef[i - 1][j] + coef[i - 1][j + 1];
            }
        }

        if (k >= 0) return coef[n][k];
        else return coef[n][Math.abs(k)];
    }

    // Takes two integer command-line arguments n and k and prints coef(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        StdOut.println(trinomial(n, k));
    } 
}
