import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;

public class Assignment
{

    private static void useScanner()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = input.nextInt();
        input.nextLine();
        System.out.println("You entered " + num);

        System.out.println("Enter a string: ");
        String str = input.nextLine();
        System.out.println("You entered " + str);

        input.close();
    }

    private static void useBufferedReader()
    {
        try
        {
            /*
            Note: The above is the same as:
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            */
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number: ");
            int num = Integer.parseInt(reader.readLine());
            System.out.println("You entered " + num);

            System.out.println("Enter a string: ");
            String str = reader.readLine();
            System.out.println("You entered " + str);

            reader.close();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void useBufferedWriter()
    {
        BufferedWriter ostream = new BufferedWriter(new OutputStreamWriter(System.out));
        ostream.write("Hello, world! from the Buffered Writer to the stdout");
        ostream.flush();
    }
    public static void main(String[] args)
    {
        useScanner();
        useBufferedReader();
        useBufferedWriter();
    }
}
