public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] ampl = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            ampl[i] = a[i] * alpha;
        }
        return ampl;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] revers = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            revers[a.length - 1 - i] = a[i];
        }
        return revers;
    }   

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] merge = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merge[i] = a[i]; 
        }
        for (int i = a.length; i < a.length + b.length; i++) {
            merge[i] = b[i - a.length]; 
        }
        return merge;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        if (a.length >= b.length) {
            double[] mix = new double[a.length];
            for (int i = 0; i < a.length; i++) {
                if (i < b.length) mix[i] = a[i] + b[i];
                else mix[i] = a[i];
            }
            return mix;
        } else {
            double[] mix = new double[b.length];
            for (int i = 0; i < b.length; i++) {
                if (i < a.length) mix[i] = a[i] + b[i];
                else mix[i] = b[i];
            }
            return mix;
        }
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int s = (int) (a.length / alpha);
        double[] speed = new double[s];
        for (int i = 0; i < s; i++) {
            int indx = (int) (i * alpha);
            speed[i] = a[indx];
        }
        return speed;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] piano = StdAudio.read("piano.wav");
        double[] beat = StdAudio.read("beatbox.wav");
        double[] chimes = StdAudio.read("chimes.wav");
        double[] singer = StdAudio.read("singer.wav");
        double[] cow = StdAudio.read("cow.wav");

        double[] amppiano = amplify(piano, 1.5);
        double[] reversinger = reverse(singer);
        double[] speedbeat = changeSpeed(beat, 0.25);
        double[] samppiano = changeSpeed(piano, 0.5);
        double[] sreversinger = changeSpeed(reversinger, 2);
        double[] mixpianobeat = mix(samppiano, speedbeat);
        double[] mixpianobeatsing = mix(mixpianobeat, sreversinger);
        double[] result = merge(cow, mixpianobeatsing);
        StdAudio.play(result);
    }
}
