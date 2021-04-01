public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a)
    {
        long counts = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    counts++;
            }
        }
        return counts;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int aHead = 0;
        int aTail = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (k >= i) {
                a[aHead] = i;
                k -= i;
                aHead++;
            }
            else {
                a[aTail] = i;
                aTail--;
            }
        }
        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
