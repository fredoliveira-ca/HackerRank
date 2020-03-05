import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String [] args) {

        long startAt = System.currentTimeMillis();
        System.out.println(Arrays.toString(IntStream.iterate(0, i -> i + 2).limit(100000).toArray()));
        long endAt = System.currentTimeMillis();
        System.out.println("execution time 1 = " + (endAt - startAt) + "ms");

        long startAt1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(IntStream.iterate(0, i -> i + 2).takeWhile(n -> n <= 100000).toArray()));
        long endAt1 = System.currentTimeMillis();
        System.out.println("execution time 2 = " + (endAt1 - startAt1) + "ms");

        long startAt11 = System.currentTimeMillis();
        System.out.println(Arrays.toString(IntStream.iterate(0, i -> i + 2).takeWhile(n -> n <= 100000).toArray()));
        long endAt11 = System.currentTimeMillis();
        System.out.println("execution time 2.1 = " + (endAt11 - startAt11) + "ms");

        long startAt2 = System.currentTimeMillis();
        int i = 0;
        for (int row = 0;  row <  100000;row++) {
            i++;
        }
        System.out.print("\n");
        long endAt2 = System.currentTimeMillis();
        System.out.println("execution time 3 = " + (endAt2 - startAt2) + "ms");

    }
}
