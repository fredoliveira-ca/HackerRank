import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {

        final List<Integer> list = arr.stream()
                .flatMap(List::stream)
                .collect(toList());

        final int diagonal1 = IntStream.iterate(0, i -> i + arr.size()+1)
                .limit(arr.size())
                .boxed()
                .mapToInt(list::get)
                .sum();

        final int diagonal2 = IntStream.iterate(arr.size()-1, i -> i + arr.size()-1)
                .limit(arr.size())
                .boxed()
                .mapToInt(list::get)
                .sum();

        return diagonal2 > diagonal1 ? diagonal2 - diagonal1 : diagonal1 - diagonal2;

    }

}

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedReader.close();
    }
}
