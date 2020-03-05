//import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Scanner;

public class Solution2 {

    // Complete the repeatedString function below.
    static long repeatedString(String s, Long n) {
        if(s.length() == 1 && s.equalsIgnoreCase("a")) return n;

        long countAs = s.chars().filter(ch -> ch == 'a').count();

        Long r = n % s.length();

        if(r > 0) {
            /*long count = StringUtils.repeat(s, r.intValue())
                    .chars()
                    .limit(r)
                    .filter(ch -> ch == 'a')
                    .count();

            return (countAs * (n / s.length())) + count;*/
            return 0;
        } else {
            return countAs * (n / s.length());
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}

