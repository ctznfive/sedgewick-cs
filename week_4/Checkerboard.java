public class Checkerboard {
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]); 
        double x = 0.5;
        double y = 0.5;
        boolean color = false;
        StdDraw.setScale(0, n);
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!color) StdDraw.setPenColor(StdDraw.BLUE);
                else StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledSquare(x, y, 0.5);
                x++;
                color = !color;
            }
            x = 0.5;
            y++;
            if (n % 2 == 0) color = !color;
        } 
    }
}
