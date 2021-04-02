public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int repeatsMax = 0;
        int repeats = 0;
        for (int i = 0; i <= dna.length() - 3; i++) {
            if ((dna.substring(i, i + 3)).equals("CAG")) {
                repeats = 1;
                for (int j = i + 3; j <= dna.length() - 3; j += 3) {
                    if ((dna.substring(j, j + 3)).equals("CAG")) {
                        repeats++;
                    }
                    else
                        break;
                }
            }
            repeatsMax = Math.max(repeats, repeatsMax);
        }
        return repeatsMax;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String strCopy = s;
        strCopy = strCopy.replace("\n", "");
        strCopy = strCopy.replace("\t", "");
        strCopy = strCopy.replace(" ", "");
        return strCopy;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        String diagnose = "";
        if (maxRepeats <= 9 || maxRepeats >= 181) diagnose = "not human";
        else if (maxRepeats <= 35) diagnose = "normal";
        else if (maxRepeats <= 39) diagnose = "high risk";
        else if (maxRepeats <= 180 || maxRepeats >= 40) diagnose = "Huntington's";
        return diagnose;
    }

    // Sample client.
    public static void main(String[] args) {
        String file = args[0];
        In inStream = new In(file);
        String dnaStr = inStream.readAll();
        String dnaStrWP = removeWhitespace(dnaStr);
        int repeats = maxRepeats(dnaStrWP);
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats));
    }

}
