import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaExceptionHandlingTryCatch {
    public static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            int x = in.nextInt();
            int y = in.nextInt();

            int result = x/y;
            System.out.println(result);
        } catch(InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
