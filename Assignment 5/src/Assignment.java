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

    public Employee(String name, int salary, String designation)
    {
        m_empID = m_empCount++;
        m_name = name;
        m_salary = salary;
        m_designation = designation;
    }

    // Compare two employees by salary
    public Employee compareTo(Employee other)
    {
        if (this.m_salary > other.m_salary)
            return this;
        else
            return other;
    }

    // Static Method to get the number of employees
    static int getCount()
    {
        return m_empCount;
    }

    String detailsToString()
    {
        return "Employee ID: " + m_empID + "\t" + "Name: " + m_name + "\t" + "Salary: " + m_salary + "\t" + "Designation: " + m_designation + "\n";
    }

    String detailsToString(int tester)
    {
        if(tester != 0)
            return "Employee ID: " + m_empID + "\t" + "Name: " + m_name + "\t" + "Salary: " + m_salary + "\t" + "Designation: " + m_designation + "\t" + "Total Employee Count: " + m_empCount + "\n";
        else
            return "";
    }
}


public class Assignment
{
    public static void main(String[] args)
    {
    Employee[] empArray = new Employee[3];
    empArray[0] = new Employee("Kells", 100000, "Manager");
    empArray[1] = new Employee("John", 200000, "Developer");
    empArray[2] = new Employee("Mary", 100000, "Tester");

    System.out.println("Employee Details:");
    for(int i = 0; i < 3; i++)
    {
        System.out.println(empArray[i].detailsToString());
    }

    System.out.println(empArray[0].compareTo(empArray[1]).detailsToString(1));

    System.out.println("Total Employee Count: " + Employee.getCount());

    }
}
