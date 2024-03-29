public class WorldMap {
    public static void main(String[] args) {
        
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString();
            int vertnum = StdIn.readInt();

            double[] x = new double[vertnum];
            double[] y = new double[vertnum];

            for (int i = 0; i < vertnum; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();

            }
            StdDraw.polygon(x, y);
        }
    }
}
