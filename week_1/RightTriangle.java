public class RightTriangle
{
    public static void main(String[] args)
	{  
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        boolean positive = (a > 0) && (b > 0) && (c > 0);
        boolean triangle = (a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == a * a + b * b);
        boolean result = positive && triangle;

        System.out.println(result);
    }
}

