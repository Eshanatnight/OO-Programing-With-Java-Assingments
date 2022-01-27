import java.io.BufferedReader;
import com.kells.List;

public class Test
{
    private final static BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

    private static void test_with_int()
    {
        // create a list of integers
        var list = new List<Integer>();

        // Let's add some elements in the list
        list.push_back(10);
        list.push_back(20);
        list.push_back(30);
        list.push_back(40);
        list.push_back(50);

        // So we have pushed 5 elements in the list
        // 10, 20, 30, 40, 50

        // this should print the list as a String via the toString() method
        System.out.println("The list contains: " + list);

        // Find the size of the list
        System.out.println("The size of the list is: " + list.size());

        // Find the element at index 2
        System.out.println("The element at index 1 is: " + list.at(2));

        // now let's try to remove an element from the list
        System.out.println("Removing the element at index 2 : 30");
        list.remove(30);

        // the list should now contain: 10, 20, 40, 50
        System.out.println("The list contains: " + list);
    }

    private static void test_with_string()
    {
        // create a list of strings
        var list = new List<String>();

        // Let's add some elements in the list
        list.push_back("Hello");
        list.push_back("World");
        list.push_back("!");
        list.push_back("!");

        // So we have pushed 5 elements in the list
        // Hello, World, !, !

        // this should print the list as a String via the toString() method
        System.out.println("The list contains: " + list);

        // Find the size of the list
        System.out.println("The size of the list is: " + list.size());

        // Find the element at index 2
        // Output: World
        System.out.println("The element at index 0 is: " + list.at(1));

        // now let's try to remove an element from the list
        // this should remove the first occurrence of the element "!"
        System.out.println("Removing the element at index 2 : !");
        list.remove("!");

        // the list should now contain: Hello, World, !
        System.out.println("The list contains: " + list);

        // Find the size of the list
        System.out.println("The size of the list is: " + list.size());
    }

    private static void test_with_char()
    {
        var list = new List<Character>();
        list.push_back('a');
        list.push_back('b');
        list.push_back('c');
        list.push_back('d');
        list.push_back('e');
        list.push_back('f');

        // Print the list
        // a, b, c, d, e, f
        System.out.println("The list contains: " + list);

        // Find the size of the list
        System.out.println("The size of the list is: " + list.size());

        // Find the element at index 2
        System.out.println("The element at index 1 is: " + list.at(2));

        // now let's try to remove an element from the list
        list.remove('c');

        // the list should now contain: a, b, d, e, f
        System.out.println("The list contains: " + list);
    }

    private static void test_with_double()
    {
        var list = new List<Double>();
        list.push_back(1.0);
        list.push_back(2.0);
        list.push_back(3.0);
        list.push_back(4.0);
        list.push_back(5.0);

        // Print the list
        // 1.0, 2.0, 3.0, 4.0, 5.0
        System.out.println("The list contains: " + list);

        // Find the size of the list
        System.out.println("The size of the list is: " + list.size());

        // Find the element at index 2
        System.out.println("The element at index 2 is: " + list.at(2));

        // now let's try to remove an element from the list
        System.out.println("Removing element at index 2");
        list.remove(3.0);

        // the list should now contain: 1.0, 2.0, 4.0, 5.0
        System.out.println("The list contains: " + list);
    }


    public static void main(String[] args)
    {

        System.out.println("Testing Suite:");
        System.out.println("==================\n");
        System.out.println("Test with int:    1");
        System.out.println("Test with String: 2");
        System.out.println("Test with char:   3");
        System.out.println("Test with double: 4");
        System.out.println("==================\n");
        System.out.print("Enter your choice: ");

        int choice = 0;

        try
        {
            choice = Integer.parseInt(reader.readLine());
        }
        catch (Exception e)
        {
            System.out.println("Invalid choice. Exiting.");
            System.exit(0);
        }

        switch (choice) {
            case 1 -> test_with_int();
            case 2 -> test_with_string();
            case 3 -> test_with_char();
            case 4 -> test_with_double();
            default ->
            {
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
            }
        }
    }

}
