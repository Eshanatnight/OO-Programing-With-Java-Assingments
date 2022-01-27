public class Assignment
{
    public static void main(String[] args)
    {
        // Instantiation of Some Strings
        String name = "Alice";
        String newName = "Athena";
        String otherName = "Ariel";
        String yetAnotherName = "alice";

        /*  Illustration of
            * equals() method
            * toUpperCase() method
            @brief: wrapped in an if-else statement
        */
        if (name.equals(newName.toUpperCase())) {
            System.out.println("Both the Strings Are Equal");
        }
        else
        {
            System.out.println("Strings are not equal");
        }
        /*  Illustration of
            * compareTo() method
            * toLowerCase() method
            * equalusIgnoreCase() method
            @brief: wrapped in an if-else statement
        */
        int comValue = name.compareTo(yetAnotherName.toLowerCase());
        // the value of the above compund statement does not
        // necessarrily need to be saved in comValue
        if (comValue == 0)
            System.out.println("Both the Strings Are Equal viz UNICODE Value");
        else
            System.out.println("Strings are not equal viz UNICODE Value");

        if (name.equalsIgnoreCase(yetAnotherName))
            System.out.println("Both the Strings Are Equal viz Ignore Case");
        else
            System.out.println("Strings are not equal viz Ignore Case");

        /*  Illustration of
            * indexOf() method
            * substring() method
            * toCharArray() method
        */

        System.out.println("Index of \' A \' is at: " + name.indexOf('A'));
        // Instantiated a new String Object for no reason at all
        String subString = yetAnotherName.substring(0, 3);
        System.out.println("Substring of \'alice\' is: " + subString + "\n\n");

        char[] charArray = otherName.toCharArray();

        // For loop to print out the characters in the charArray
        for (int j = 0; j < charArray.length; j++)
            System.out.print("Char at index " + String.valueOf(j) + " is: " + charArray[j] + "\n");

        // Illustrates the API Function charAt
        // charAt returns a char, which I then used to Log to the console
        for (int i = 0; i < name.length(); ++i)
            System.out.println(name.charAt(i));

        /*  Illustration of
            * trim() method
        */
        String newString = "     HEllo  My     Name is Kazu     ";
        newName = newString.trim();
        System.out.println("String Before Trim: " + newString);
        System.out.println("Trimmed String is: " + newName);
    }
}
