import java.util.Scanner;

public class Solution3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[]argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            double total = a;
            for (int j = 0; j < n; j++) {
                total = calcExpression(a, b, j, total);
            }
        }
        in.close();
    }

    private static double calcExpression(int a, int b, int j, double total) {
        double result = Math.pow(2, j) * b;

        total = total + result;

        System.out.print(String.format("%.0f", total) + " ");

        return total;
    }
}