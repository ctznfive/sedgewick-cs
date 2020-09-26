public class Birthday {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] num = new int[n + 2];
        int[] count = new int[n + 2];

        for (int i = 0; i < trials; i++) {
            int indx = 0;
            boolean sharebday = false;
            while (!sharebday) {
                int r = (int) (Math.random() * n);
                num[indx] = r;
                for (int j = 0; j < indx; j++) {
                    if (num[j] == r) {
                        sharebday = true;
                        break;
                    }
                }
                indx++;
            }
            count[indx] += 1;
        }

        for (int i = 1; i <= n + 1; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++)
				sum += count[j];

            double frac = ((double) sum / (double) trials);
            System.out.print(i + "\t" + count[i] + "\t" + frac + "\t");
            System.out.println();
            if (frac >= 0.5) break;
        }
    }
}
