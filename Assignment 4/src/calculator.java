public class calculator
{
    public static double calculate(double num1, double num2, String operator)
    {
        double result = 0;
        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "x" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
            case "%" -> result = num1 % num2;
            case "^" -> result = Math.pow(num1, num2);
            default -> System.out.println("Invalid operator");
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to the calculator!");

        if(args.length != 3)
            System.out.println("Invalid Arguments Given");

        String operator = args[2];

        // Note: had to use the char 'x' as the symbol for Multiplication
        // Note: terminal will not accept the symbol '*' (Old Terminal Bug)

        double num1 = Double.parseDouble(args[0]);
        double num2 = Double.parseDouble(args[1]);

        System.out.println("The result is: " + calculate(num1, num2, operator));
    }
}