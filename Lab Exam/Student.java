public class Student
{
    String m_name;
    int m_rollNo;
    String m_department;
    double m_marks;

    public Student(String name, int rollNo, String department, double marks)
    {
        m_name = name;
        m_rollNo = rollNo;
        m_department = department;
        m_marks = marks;
    }

    /*
        * Sorts a given array of Student objects in ascending order of marks
        * Since we need the Student with Most Marks, Least Marks and the student with average marks
        * we can sort the array rather than comparing the marks of each student everytime we need to find
        * the student with the highest marks or the lowest marks or the average marks
        * less computation overall and less number of times we have to traverse the array
    */
    public static void sort(Student[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j].m_marks > arr[j+1].m_marks)
                {
                // swaps arr[j+1] and arr[j]
                Student temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                }
            }
        }
    }

    public static double calculateAverage(Student[] arr)
    {
        double sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i].m_marks;
        }
        return sum/arr.length;
    }

    public static void printStudentsWithMoreThanAvgMarks(Student[] arr)
    {
        double avg = calculateAverage(arr);
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i].m_marks > avg)
            {
                System.out.println("Name: " + arr[i].m_name + "   RollNo: " + arr[i].m_rollNo + "   Marks: " + arr[i].m_marks);
            }
        }
    }


    // main function the entry point of the program
    public static void main(String[] args)
    {
        Student[] arr = new Student[5];

        arr[0] = new Student("A", 1, "CSE", 80);
        arr[1] = new Student("B", 2, "CSE", 75);
        arr[2] = new Student("C", 3, "CSE", 75);
        arr[3] = new Student("D", 4, "CSE", 85);
        arr[4] = new Student("E", 5, "CSE", 90);

        sort(arr);

        System.out.println("\nStudent with the highest marks is:   Name: " + arr[4].m_name + "   RollNo: " + arr[4].m_rollNo + "   Marks: " + arr[4].m_marks);
        System.out.println("Student with the lowest marks is:    Name: " + arr[0].m_name + "   RollNo: " + arr[0].m_rollNo + "   Marks: " + arr[0].m_marks);
        System.out.println("Students with more than the average marks is: ");
        printStudentsWithMoreThanAvgMarks(arr);

    }
}


