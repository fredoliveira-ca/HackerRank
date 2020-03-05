import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

    public static void main(String[]argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();

        Map<String, Integer> bookMap = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();

            int phone=in.nextInt();

            bookMap.put(name, phone);

            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();

            Integer number = bookMap.get(s);

            if(number == null) {
                System.out.println("Not found");
            } else {
                System.out.println(s+"="+bookMap.get(s));
            }

        }
    }

}
