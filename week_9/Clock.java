public class Clock {

    private int hours;
    private int min;

    private void isTimeValid() {
        if (this.hours < 0 || this.hours > 23)
            throw new IllegalArgumentException("Range of hours: 0 - 23");
        if (this.min < 0 || this.min > 59)
            throw new IllegalArgumentException("Range of minutes: 0 - 59");
    }

    private void isTimeOver() {
        if (this.min >= 60) {
            this.hours++;
            this.min -= 60;
        }
        if (this.hours >= 24)
            this.hours = this.hours % 24;
    }

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        this.hours = h;
        this.min = m;
        isTimeValid();
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5)
            throw new IllegalArgumentException("String format: HH:MM");
        if (!s.contains(":"))
            throw new IllegalArgumentException("String format: HH:MM");

        String a = s.substring(0, 2);
        String b = s.substring(3, 5);
        this.hours = Integer.parseInt(a);
        this.min = Integer.parseInt(b);
        isTimeValid();
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String hoursStr = "";
        String minStr = "";
        if (this.hours < 10)
            hoursStr = "0" + Integer.toString(this.hours);
        else
            hoursStr = Integer.toString(this.hours);
        if (this.min < 10)
            minStr = "0" + Integer.toString(this.min);
        else
            minStr = Integer.toString(this.min);
        return (hoursStr + ":" + minStr);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        boolean isEarlier = false;
        if (this.hours < that.hours)
            isEarlier = true;
        else if (this.hours == that.hours) {
            if (this.min < that.min)
                isEarlier = true;
        }
        return isEarlier;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.min++;
        isTimeOver();
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Delta must be positive");

        int deltaHours = (delta / 60) % 24;
        int deltaMin = delta % 60;
        this.min += deltaMin;
        isTimeOver();
        this.hours += deltaHours;
        isTimeOver();
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock1 = new Clock(4, 9);
        Clock clock2 = new Clock("04:09");
        Clock clock3 = new Clock("23:59");

        StdOut.println(clock1.toString());
        StdOut.println(clock2.toString());
        StdOut.println(clock3.toString());

        clock3.tic();
        StdOut.println(clock3.toString());
        StdOut.println(clock3.isEarlierThan(clock1));
        StdOut.println(clock1.isEarlierThan(clock2));

        clock3.toc(70);
        StdOut.println(clock3.toString());
    }
}
