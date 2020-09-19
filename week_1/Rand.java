public class Rand
{
    public static void main (String[] args)
    {
        int n = 5;
        double a = Math.random();
        double b = Math.random();
        double c = Math.random();
        double d = Math.random();
        double e = Math.random();
        double min = Math.min(Math.min(Math.min(a, b), Math.min(c, d)), e);
        double max = Math.max(Math.max(Math.max(a, b), Math.max(c, d)), e);
        double mean = (a + b + c + d + e) / n;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("mean = " + mean);
    }
}
