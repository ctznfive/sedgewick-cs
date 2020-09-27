public class ShannonEntropy {
    public static void main (String[] args) {

        int m = Integer.parseInt(args[0]);
        int[] num = new int[m + 1];
        int sum = 0;
        double entropy = 0.0;
        
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            num[a]++;
        }

        for (int i = 1; i <= m; i++)
            sum += num[i];

        for (int i = 1; i <= m; i++) {
            double p = (double) num[i] / sum;
            if (p != 0)
                entropy -= p * (Math.log(p) / Math.log(2));
        }

        StdOut.printf("%.4f\n", entropy);
    }
}
