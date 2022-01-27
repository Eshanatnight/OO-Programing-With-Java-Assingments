import simpleIO.Console;

public class assignment
{
    public static void main(String[] args) throws Exception
    {
        Console.log("Hello World!\n");

        String name;
        name = Console.read_line("What is your name?\n");

        Console.log("Hello " + name + "\n");


        /*
        Console.log(100);

        Trying to compile with the above line will result in a compile error.
        assignment.java:16: error: no suitable method found for log(int)
        method Console.log(int) is not applicable
        (log(int) is not public in Console; cannot be accessed from outside package)
        Bascically its a visibilaty error.
        The overload with Integer as parameter is not public but protected
        */

        /*
        Console.log(1.224);

        Trying to compile with the above line will result in a compile error.
        assignment.java:29: error: no suitable method found for log(double)
        method Console.log(double) is not applicable
        (log(double) is not public in Console; cannot be accessed from outside package)

        Again its a visibilaty error.
        The overload for log with Double as parameter is not public but private
        */

        /*
        Console.log('a');

        Trying to compile with the above line will result in a compile error.

        assignment.java:39: error: no suitable method found for log(char)
        method Console.log(char) is not applicable
        (log(char) is not public in Console; cannot be accessed from outside package)

        Again its a visibilaty error.
        The overload for log with Character as parameter does not have a specifier explicitly stating that it is public.
        Hence the compiler is defaulting to private.
        */
    }



}
