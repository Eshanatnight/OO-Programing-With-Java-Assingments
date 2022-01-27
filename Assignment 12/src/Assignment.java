class InBuiltExceptionDemo
{
    public static void arrayIndexOutOfBoundsException()
    {
        // Array Out Of Bound Exception
        try
        {
            int[] arr = {1, 2, 3, 4, 5};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Exception caught" + e);
        }
        finally
        {
            System.out.println("Finally block for InBuiltExceptionDemo is Executed\n");
        }
    }

    public static void divisionByZero()
    {
        // Division by Zero Exception
        try
        {
            int a = 10;
            int b = 0;
            int c = a / b;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Exception Occured: " + e);
        }
        finally
        {
            System.out.println("Finally Block for InBuiltExceptionDemo is Executed\n");
        }
    }
}

// We Created a Custom Exception
class CustomException extends Exception
{
    public CustomException(String message)
    {
        super(message);
    }
}

class CustomExceptionDemo
{
    static void validate(int age) throws CustomException
    {
        if(age < 18)
        {
            throw new CustomException("Age is less than 18");
        }
    }

    static void customException(int age)
    {
        try
        {
            validate(age);
        }

        catch (CustomException e)
        {
            System.out.println("Exception Caught " + e);
        }

        finally
        {
            System.out.println("Finally Block for CustomExceptionDemo Executed\n");
        }
    }
}

public class Assignment
{
    public static void main(String[] args)
    {
        InBuiltExceptionDemo.arrayIndexOutOfBoundsException();
        InBuiltExceptionDemo.divisionByZero();

        int age = 10;
        CustomExceptionDemo.customException(age);

    }
}