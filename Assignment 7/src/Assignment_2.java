public class Assignment_2
{
    public static void main(String[] args)
    {
        // Instantiate a StringBuffer viz a String
        StringBuffer buffer = new StringBuffer("Hello World");

        // Append to the buffer
        buffer.append("You all suck!");

        // Illustration of the toString() method to print the buffer
        System.out.println(buffer.toString());

        // Illustration of the capacity() method to print the capacity of the buffer
        System.out.println("Capacity of the Buffer: " + buffer.capacity());

        // Illustration of the charAt() method to print the character at index 3
        System.out.println("Char at index [3]: " + buffer.charAt(3));

        // Illustration of the delete() method to delete the first 5 Characters
        buffer.delete(0, 5);
        System.out.println("After deleting 5 characters: " + buffer.toString());

        // Illustration of the deleteCharAt() method to delete the character at index 5
        buffer.deleteCharAt(5);

        // Illustration of the ensureCapacity() method to increase the capacity of the buffer
        buffer.ensureCapacity(25);

        // Instantiate a char array
        char [] charArray = new char[25];

        // Get the characters from the buffer and store them in the char array via getChars() method
        buffer.getChars(0, 4, charArray, 1);

        // Print the char array
        System.out.println("After getting chars:");
        for(char c : charArray)
            System.out.print(c + " ");
        System.out.println("\n");

        // Finding the starting index of the substring "You" in the buffer
        System.out.println("Index of \'You\': " + buffer.indexOf("You"));

        // Illustration of the insert() method to insert the string "Bye" at index 0
        buffer.insert(0, " Bye ");

        // Illustration of the setCharAt() method to set the character at index 0 to '#'
        // Then print the buffer
        buffer.setCharAt(0, '#');
        System.out.println("After Alterations:  " + buffer.toString());

        // Instantiate a new Buffer via a String
        StringBuffer buffer2 = new StringBuffer("Dead End");

        // Illustration of the setLength() method to set the length of the buffer to 12
        // Then Printing the Buffer with the toString() method
        buffer2.setLength(12);
        System.out.println("After setting length: " + buffer2.toString());

        // Illustration of the substring() method to print the substring from index 0 to index 5
        System.out.println("After substring: " + buffer2.substring(0, 5).toString());
    }
}
