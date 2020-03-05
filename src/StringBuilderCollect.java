import java.util.Arrays;
import java.util.Scanner;

public class StringBuilderCollect {

    static boolean isAnagram(String a, String b) {
        int[] charsA = a.toLowerCase().chars().sorted().toArray();
        int[] charsB = b.toLowerCase().chars().sorted().toArray();

        boolean b1 = Arrays.equals(charsA, charsB);

        return true;
    }

    static boolean isAnagram2(String a, String b) {
        StringBuilder charsA = a.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        StringBuilder charsB = b.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);

        System.out.println(charsA);
        System.out.println(charsB);

        boolean b1 = charsA.equals(charsB);

        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
