import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MiniMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        ArrayList<Long> sums = new ArrayList();

        final long[] arr2 = filterEquals(arr, arr[0]);

        if(arr2.length == arr.length) {
            arr2[0] = 0;
            sums.add(Arrays.stream(arr2).sum());
        } else {
            for (int value : arr) {
                final long[] longs = filterNotEquals(arr, value);
                sums.add(Arrays.stream(longs).sum());
            }
        }

        System.out.println(sums.stream().min(Comparator.comparing(Long::valueOf)).get() +
                " " + sums.stream().max(Comparator.comparing(Long::valueOf)).get());

    }

    private static long[] filterNotEquals(int[] arr, int number) {
        return Arrays.stream(arr).filter(i -> i != number).mapToLong(Long::valueOf).toArray();
    }

    private static long[] filterEquals(int[] arr, int number) {
        return Arrays.stream(arr).filter(i -> i == number).mapToLong(Long::valueOf).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}

