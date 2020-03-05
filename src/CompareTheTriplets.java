import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> alice, List<Integer> bob) {
        AtomicInteger alicesPoints = new AtomicInteger();
        AtomicInteger bobPoints = new AtomicInteger();
        var size = alice.size();

        for (int i = 0; i < size; i++) {
            boolean isAliceAwarded = compareRateGreaterThan(alice.get(i), bob.get(i));
            boolean isBobAwarded = compareRateGreaterThan(bob.get(i), alice.get(i));

            if(isAliceAwarded) alicesPoints.getAndIncrement();
            if(isBobAwarded) bobPoints.getAndIncrement();
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(alicesPoints.get());
        arrayList.add(bobPoints.get());

        return arrayList;
    }

    private static boolean compareRateGreaterThan(Integer x, Integer y) {
        return x > y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        String collect = result.stream()
                .map(Object::toString)
                .collect(joining(" "));

        System.out.println(collect);

        /*bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );*/

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
