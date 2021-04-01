public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        for (long a = 1; a <= (long) Math.cbrt(n); a++) {
            long b = (long) Math.cbrt(n - a * a * a);
            if (n - a * a * a == b * b * b) {
                for (long c = a + 1; c <= (long) Math.cbrt(n); c++) {
                    long d = (long) Math.cbrt(n - c * c * c);
                    if (n - c * c * c == d * d * d && a != d)
                        return true;
                }
                break;
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
