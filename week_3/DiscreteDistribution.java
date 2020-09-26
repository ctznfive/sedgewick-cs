public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;

        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + Integer.parseInt(args[i]);

        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * (sum[n - 1]));

            int indx = 0;
            while (r >= sum[indx])
                indx++;

            System.out.print(indx + " ");
        }
    }
}
