package simpleIO;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*
    This is a Simple Console I/O Class.

    For the input, it uses InputStreamReader and BufferedReader.
    Safety is not guaranteed.  But should be decently safe for debugging.

    *   Why i wrote this class?
    Ans: Because I did not want to write System.out.println() and System.out.print()
    Everytime i want something to be written to the console.

    * In the log function, to print a new line, you can use "\n"

*/
public class Console
{
    // Any non-string object will need to be explicitly converted to string.
    // the compiler may do it automatically. But to be safe, just typecast it.
    public static void log(String message)
    {
        System.out.print(message);
    }


    public static String read_line() throws Exception
    {
        InputStreamReader istream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(istream);

        String input;
        input = reader.readLine();

        reader.close();
        istream.close();

        return input;
    }


    // Any non-string object will need to be explicitly converted to string.
    // the compiler may do it automatically. But to be safe, just typecast it.
    public static String read_line(String message) throws Exception
    {
        Console.log(message);
        return read_line();
    }


    protected static void log(int message)
    {
        Console.log(Integer.toString(message));
    }


    private static void log(double message)
    {
        Console.log(Double.toString(message));
    }

    static void log(char message)
    {
        Console.log(Character.toString(message));
    }

}

