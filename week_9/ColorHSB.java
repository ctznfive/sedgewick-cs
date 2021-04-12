public class ColorHSB {

    private final int colorHue;
    private final int colorSatur;
    private final int colorBright;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");

        this.colorHue = h;
        this.colorSatur = s;
        this.colorBright = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        String str = "(" + this.colorHue + ", " + this.colorSatur + ", " + this.colorBright + ")";
        return str;
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (this.colorSatur == 0 || this.colorBright == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null)
            throw new IllegalArgumentException("the argument is null");

        int minHue1 = (int) Math.pow(this.colorHue - that.colorHue, 2);
        int minHue2 = (int) Math.pow(360 - Math.abs(this.colorHue - that.colorHue), 2);
        int distanceHue = Math.min(minHue1, minHue2);
        int distanceSatur = (int) Math.pow(this.colorSatur - that.colorSatur, 2);
        int distanceBright = (int) Math.pow(this.colorBright - that.colorBright, 2);

        return (distanceHue + distanceSatur + distanceBright);
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int minDistance = Integer.MAX_VALUE;
        ColorHSB nearColor = null;
        String nearColorName = "";

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB argColor = new ColorHSB(h, s, b);

        while (!StdIn.isEmpty()) {
            String colorName = StdIn.readString();
            int colorH = StdIn.readInt();
            int colorS = StdIn.readInt();
            int colorB = StdIn.readInt();
            ColorHSB defColor = new ColorHSB(colorH, colorS, colorB);

            int newDistance = argColor.distanceSquaredTo(defColor);
            if (newDistance < minDistance) {
                minDistance = newDistance;
                nearColor = defColor;
                nearColorName = colorName;
            }
        }

        StdOut.println(nearColorName + " " + nearColor);
    }

}
