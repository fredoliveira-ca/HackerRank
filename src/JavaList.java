import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JavaList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] quantity = scanner.nextLine().split(" ");
        String[] integers = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> numbers = new ArrayList<>();

        numbers.addAll(Arrays.stream(integers)
                .mapToInt(Integer::valueOf).boxed()
                .collect(Collectors.toList()));

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = scanner.nextLine();

            if(operation.equals("")) {
                operation = scanner.nextLine();
            }

            if(operation.equals("Insert")) {
                String[] nToInsert = scanner.nextLine().split(" ");

                numbers.add(Integer.parseInt(nToInsert[0]),
                        Integer.parseInt(nToInsert[1]));
            }

            if(operation.equals("Delete")) {
                int deleteIndex = scanner.nextInt();
                numbers.remove(deleteIndex);
            }
        }

        scanner.close();

        numbers.forEach(value -> System.out.print(value + " "));
    }
}
