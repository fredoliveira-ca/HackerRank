import java.util.Arrays;
import java.util.Scanner;

public class ApplesAndOranges {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int startSamsHouse, int endSamsHouse, int appleTree, int orangeTree, int[] applesDistance, int[] orangesDistance) {

        System.out.println(startSamsHouse +"-"+endSamsHouse);

        long applesInsideSamsHouse = Arrays.stream(applesDistance)
                .map(distance -> {
                    System.out.println(appleTree + " - " + distance + " - " + (appleTree + distance));
                    return appleTree + distance;
                })
                .filter(land -> {
                    System.out.println(startSamsHouse + " <= " + land + " - " + land + " >= " +endSamsHouse);
                    System.out.println(startSamsHouse <= land && land <= endSamsHouse);
                    return startSamsHouse <= land && land >= endSamsHouse;
                }).count();

        System.out.println(applesInsideSamsHouse);

        long orangesInsideSamsHouse = Arrays.stream(orangesDistance)
                .map(distance -> {
                    System.out.println(orangeTree + " - " + distance + " - " + (orangeTree + distance));
                    return orangeTree + distance;
                })
                .filter(land -> {
                    System.out.println(startSamsHouse + " <= " + land + " - " + land + " >= " +endSamsHouse);
                    System.out.println(startSamsHouse <= land && land <= endSamsHouse);
                    return startSamsHouse <= land && land >= endSamsHouse;
                }).count();
        System.out.println(orangesInsideSamsHouse);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");

        int s = Integer.parseInt(st[0]);

        int t = Integer.parseInt(st[1]);

        String[] ab = scanner.nextLine().split(" ");

        int a = Integer.parseInt(ab[0]);

        int b = Integer.parseInt(ab[1]);

        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        int[] apples = new int[m];

        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int applesItem = Integer.parseInt(applesItems[i]);
            apples[i] = applesItem;
        }

        int[] oranges = new int[n];

        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int orangesItem = Integer.parseInt(orangesItems[i]);
            oranges[i] = orangesItem;
        }

        countApplesAndOranges(s, t, a, b, apples, oranges);

        scanner.close();
    }
}
