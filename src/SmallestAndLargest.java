import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SmallestAndLargest {

    private static String getSmallestAndLargest(String s, int k) {

        AtomicInteger k1 = new AtomicInteger(0);
        AtomicInteger k2 = new AtomicInteger(k);

        LinkedList list = s.chars()
                .filter(i -> k2.get() <= s.length())
                .mapToObj(i -> {
                    String substring = s.substring(k1.get(), k2.get());
                    k1.getAndIncrement();
                    k2.getAndIncrement();

                    return substring;
                }).sorted().collect(Collectors.toCollection(LinkedList::new));

        return list.getFirst() + "\n" + list.getLast();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }

}

