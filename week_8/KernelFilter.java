import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        Picture target = new Picture(picture.width(), picture.height());

        for (int col = 0; col < picture.width(); col++) {
            for (int row = 0; row < picture.height(); row++) {
                double redTarget = 0;
                double greenTarget = 0;
                double blueTarget = 0;

                int y = 0;
                for (int i = col - weights.length / 2; i <= col + weights.length / 2; i++) {
                    int x = 0;
                    for (int j = row - weights.length / 2; j <= row + weights.length / 2; j++) {

                        /* Periodic boundary conditions */
                        int iBoundary = Math.floorMod(i, picture.width());
                        int jBoundary = Math.floorMod(j, picture.height());

                        Color color = picture.get(iBoundary, jBoundary);
                        int red   = color.getRed();
                        int green = color.getGreen();
                        int blue  = color.getBlue();
                        redTarget   += weights[y][x] * red;
                        greenTarget += weights[y][x] * green;
                        blueTarget  += weights[y][x] * blue;
                        x++;
                    }
                    y++;
                }

                redTarget   =     (redTarget < 0) ? 0   : Math.round(redTarget);
                greenTarget =   (greenTarget < 0) ? 0   : Math.round(greenTarget);
                blueTarget  =    (blueTarget < 0) ? 0   : Math.round(blueTarget);
                redTarget   =   (redTarget > 255) ? 255 : Math.round(redTarget);
                greenTarget = (greenTarget > 255) ? 255 : Math.round(greenTarget);
                blueTarget  =  (blueTarget > 255) ? 255 : Math.round(blueTarget);

                Color colorTarget = new Color((int) redTarget, (int) greenTarget, (int) blueTarget);
                target.set(col, row, colorTarget);
            }
        }
        return target;
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = { { 0.0, 0.0, 0.0 },
                               { 0.0, 1.0, 0.0 },
                               { 0.0, 0.0, 0.0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = { { 1.0 / 16, 2.0 / 16, 1.0 / 16 },
                               { 2.0 / 16, 4.0 / 16, 2.0 / 16 },
                               { 1.0 / 16, 2.0 / 16, 1.0 / 16 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = { {  0.0, -1.0,  0.0 },
                               { -1.0,  5.0, -1.0 },
                               {  0.0, -1.0,  0.0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = { { -1.0, -1.0, -1.0 },
                               { -1.0,  8.0, -1.0 },
                               { -1.0, -1.0, -1.0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = { { -2.0, -1.0, 0.0 },
                               { -1.0,  1.0, 1.0 },
                               {  0.0,  1.0, 2.0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i != j)
                    weights[i][j] = 0.0;
                else
                    weights[i][j] = 1.0 / 9;
            }
        }
        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        source.show();
        identity(source).show();
        gaussian(source).show();
        sharpen(source).show();
        laplacian(source).show();
        emboss(source).show();
        motionBlur(source).show();
    }

}
