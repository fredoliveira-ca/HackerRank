package implementation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Kangaroo {

    // Complete the kangaroo function below.
    static String kangaroo(final int kangaroo1, final int velocityK1, final int kangaroo2, final int velocityK2) {

        if ((kangaroo1 > kangaroo2 && velocityK1 > velocityK2) || (kangaroo2 > kangaroo1 && velocityK2 > velocityK1)) {
            return "NO";
        }

        long range = kangaroo1 + kangaroo2 + velocityK1;

        AtomicInteger indexK1 = new AtomicInteger();
        final List<Long> jumpsK1 = LongStream.iterate(kangaroo1, k -> k + velocityK1)
                .limit(range)
                .mapToObj(jump -> Long.parseLong(indexK1.getAndIncrement() + "" + jump))
                .collect(Collectors.toList());

        AtomicInteger indexK2 = new AtomicInteger();
        final List<Long> jumpsK2 = LongStream.iterate(kangaroo2, k -> k + velocityK2)
                .limit(range)
                .mapToObj(jump -> Long.parseLong(indexK2.getAndIncrement() + "" + jump))
                .collect(Collectors.toList());

        final Set<Long> collect = jumpsK1.stream()
                .distinct()
                .filter(jumpsK2::contains)
                .collect(Collectors.toSet());

        return collect.size() > 0 ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        scanner.close();
    }
}
