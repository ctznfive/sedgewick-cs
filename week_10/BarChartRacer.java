import java.util.Arrays;

public class BarChartRacer {

    public static void main (String[] args) {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In data = new In(filename);

        String title = data.readLine();
        String xAxis = data.readLine();
        String sourse = data.readLine();
        data.readLine();

        BarChart barChart = new BarChart(title, xAxis, sourse);
        StdDraw.setCanvasSize(500, 500);
        StdDraw.enableDoubleBuffering();

        while (data.hasNextLine()) {
            int n = Integer.parseInt(data.readLine());
            Bar[] bars = new Bar[n];
            for (int i = 0; i < n; i++) {
                String item = data.readLine();
                String[] elem = item.split(",");
                bars[i] = new Bar(elem[1], Integer.parseInt(elem[3]), elem[4]);
                barChart.setCaption(elem[0]);
            }

            Arrays.sort(bars);
            for (int i = n - 1; i >= Math.max(0, n - k); i--) {
                barChart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            barChart.draw();
            StdDraw.show();
            StdDraw.pause(5);
            StdDraw.clear();
            barChart.reset();

            data.readLine();
        }
    }
}
