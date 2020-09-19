public class RandomWalkers {
    
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double sumsteps = .0;
        
        if (r > 0 && trials > 0) {
            for (int i = 0; i < trials; i++) {
                int steps = 0;
                int x = 0;
                int y = 0;
                while (Math.abs(x) + Math.abs(y) < r) {
                    double prob = Math.random();
                    if (prob < 0.25) x++;
                    else if (prob < 0.5) x--;
                    else if (prob < 0.75) y++;
                    else y--;
                    steps++;
                }
                sumsteps += steps;
            }
            double avgsteps = sumsteps / trials;
            System.out.println("average number of steps = " + avgsteps);
        }
        else if (r == 0 && trials > 0) {
            System.out.println("average number of steps = 0.0");
        }
        else
            System.out.println("Please, enter positive numbers (r and trials)");
    }
}
