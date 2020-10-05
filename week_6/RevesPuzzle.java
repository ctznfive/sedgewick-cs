public class RevesPuzzle {

    private static void classichanoi(int n, int disc, char from, char to, char temp) {
        if (n == 0) return;
        classichanoi(n - 1, disc - 1, from, temp, to);
        StdOut.println("Move disc " + disc + " from " + from + " to " + to);
        classichanoi(n - 1, disc - 1, temp, to, from);
    }

    private static void reveshanoi(int n, char from, char to, char temp1, char temp2) {
        if (n == 0) return;
        int k = (int) (n + 1 - Math.sqrt(2 * n + 1));
        reveshanoi(k, from, temp1, to, temp2);
        classichanoi(n - k, n, from, to, temp2);
        reveshanoi(k, temp1, to, from, temp2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k0 = (int) (n + 1 - Math.sqrt(2 * n + 1));
        reveshanoi(k0, 'A', 'B', 'C', 'D');
        classichanoi(n - k0, n, 'A', 'D', 'C');
        reveshanoi(k0, 'B', 'D', 'A', 'C');
    }
}
