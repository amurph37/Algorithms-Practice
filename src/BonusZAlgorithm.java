import java.util.ArrayList;
import java.util.List;

public class BonusZAlgorithm {

    // Method to calculate Z-array
    public static int[] calculateZ(String concatenated) {
        int n = concatenated.length();
        int[] Z = new int[n];
        int L = 0, R = 0, K;

        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && concatenated.charAt(R) == concatenated.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                K = i - L;
                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];
                } else {
                    L = i;
                    while (R < n && concatenated.charAt(R) == concatenated.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }

        return Z;
    }

    // Method to search for pattern in the text using Z-Algorithm
    public static List<Integer> search(String S, String pat) {
        String concatenated = pat + "$" + S;
        int l = concatenated.length();
        int p = pat.length();

        int[] Z = calculateZ(concatenated);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            if (Z[i] == p) {
                result.add(i - p - 1 + 1); // Converting to 1-based index
            }
        }

        return result;
    }

    // Main method to test the search
    public static void main(String[] args) {
        String S = "batmanandrobinarebat";
        String pat = "bat";

        List<Integer> result = search(S, pat);

        if (result.isEmpty()) {
            System.out.println("Pattern not found");
        } else {
            for (int index : result) {
                System.out.print(index + " ");
            }
        }
    }
}
