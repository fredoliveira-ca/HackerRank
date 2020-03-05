import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        final Number positives = Arrays.stream(arr).filter(i -> i > 0).count();
        final Number negatives = Arrays.stream(arr).filter(i -> i < 0).count();
        final Number zeros = Arrays.stream(arr).filter(i -> i == 0).count();

        System.out.println(round(positives.doubleValue()/arr.length, 6));
        System.out.println(round(negatives.doubleValue()/arr.length, 6));
        System.out.println(round(zeros.doubleValue()/arr.length, 6));
    }

    private static BigDecimal round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
