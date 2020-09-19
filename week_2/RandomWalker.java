public class RandomWalker
{
    public static void main(String[] args)
    {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        
        if (r > 0)
        {
            int steps = 0;
            System.out.println("(0, 0)");
            while (Math.abs(x) + Math.abs(y) < r)
            {
                double prob = Math.random();
                if (prob < 0.25)
                {
                    x++;
                }
                else if (prob < 0.5)
                {
                    x--;
                }
                else if (prob < 0.75)
                {
                    y++;
                }
                else
                {
                    y--;
                }
                System.out.println("(" + x + ", " + y + ")");
                steps++;
            }
            System.out.println("steps = " + steps);
        }
        else if (r == 0) {
            System.out.println("(0, 0)");
            System.out.println("steps = 0");
        }
        else
            System.out.println("Please, enter a positive number r");
    }
}
