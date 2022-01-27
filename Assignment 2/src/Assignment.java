class Employee
{
    /*
        // Data Members Set to Private
        // m_ prefix is used to indicate that the variable is a data member
    */
    private static int m_empCount = 0;
    private int m_empID;
    private String m_name;
    private int m_salary;
    private String m_designation;

    /* Notes:
        // Three Constructors for Each type of Employee
        // Personally won't use this class like this
        // it is better to inherit from Employee to FRESHERS, EXECUTIVE, TEMORARY resectively
    */
    public Employee(String name) // Constructor for Freshers
    {
        m_empID = 00001;
        m_name = name;
        m_salary = 5000;
        m_designation = "Undetermined";
    }

    public Employee(String name, int salary, String designation) // Constructor for Executive
    {
        m_empID = 01121;
        m_name = name;
        m_salary = salary;
        m_designation = designation;
    }

    public Employee()  // Constructor for Temporary
    {
        // STRING elements are padded with spaces for better look while printing on the console out
        m_empID = 0;
        m_name = "     ";
        m_salary = 0;
        m_designation = "     ";
    }

    public String detailsToString()
    {
        return "ID: " + m_empID + "\t Name: " + m_name + "\t Salary: " + m_salary + "\t Designation: " + m_designation;
    }

}

public class Assignment
{
    // Main Function
    public static void main(String[] args)
    {
        Employee[] employees = new Employee[3];
        /*
        // employess[0] = Freshers
        // employees[1] = Executive
        // employees[2] = Temporary
        */

        employees[0] = new Employee("John");
        employees[1] = new Employee("Alice", 50000, "Manager");
        employees[2] = new Employee();

        // Printing the Details of each Employee
        System.out.println("\nDetails of the Employees: ");
        System.out.println(employees[0].detailsToString());
        System.out.println(employees[1].detailsToString());
        System.out.println(employees[2].detailsToString());
    }
}