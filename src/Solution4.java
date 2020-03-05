import java.util.Scanner;

class Solution4 {
    public static void main(String[]argh) {
        Scanner scan = new Scanner(System.in);

        int i = 1;
        // Printing the delimiter used
        System.out.println("i " + scan.nextLine());
        // Printing the tokenized Strings
        while (scan.hasNext()) {
            System.out.println(i + " " + scan.nextLine());
            i++;
        }
        // closing the scanner stream
        scan.close();
    }
}