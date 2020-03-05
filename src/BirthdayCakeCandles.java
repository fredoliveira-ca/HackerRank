import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandles {

    // Complete the birthdayCakeCandles function below.
    static long birthdayCakeCandles(int[] ar) {
        final int max = Arrays.stream(ar).max().getAsInt();
        return Arrays.stream(ar).filter(i -> i == max).count();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        long result = birthdayCakeCandles(ar);

        System.out.println(result);

        scanner.close();
    }
}

