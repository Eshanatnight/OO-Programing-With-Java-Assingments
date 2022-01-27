import java.util.Arrays;
import java.util.Comparator;

class Student
{
    String m_name;
    int m_rollNo;
    String m_department;
    int m_marks;

    public Student(String name, int rollNo, String department, int marks)
    {
        m_name = name;
        m_rollNo = rollNo;
        m_department = department;
        m_marks = marks;
    }
}

class SortByMarks implements Comparator<Student>
{
    public int compare(Student s1, Student s2)
    {
        return s1.m_marks - s2.m_marks;
    }
}

class BubbleSort
{
    // This method sorts the array of students
    public static void bubbleSort(Student[] arr)
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (arr[j].m_marks > arr[j+1].m_marks)
                {
                // swap arr[j+1] and arr[j]
                Student temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                }
            }
        }
    }
}


class MergeSort
{
    static void merge(Student[] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        Student L[] = new Student[n1];
        Student R[] = new Student[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i].m_marks <= R[j].m_marks)
            {
                arr[k] = L[i];
                i++;
            }

            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    public static void sort(Student[] arr, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }

    }
}


public class Assignment
{
    public static void main(String[] args)
    {
        Student[] students = new Student[5];

        for(int i = 0; i < students.length; i++)
        {
            students[i] = new Student("Student " + (i + 1), i + 1, "Department " + (i + 1), i + 1);
        }

        // Sorts the students by their marks
        Arrays.sort(students, new SortByMarks());
        System.out.println("Student with Highest marks:\t Name: " + students[students.length - 1].m_name + "\tMarks: " + students[students.length - 1].m_marks);

        System.out.println("Student with Lowest marks: \t Name: " + students[0].m_name + "\tMarks: " + students[0].m_marks);

        // As the Array of Students is sorted by marks, the average is the middle element
        // I know it is a Hacky way to do it, but I am too lazy to implement a better way
        System.out.println("Student with the Average marks:\t Name: " + students[students.length / 2 + 1].m_name + "\tMarks: " + students[students.length / 2 + 1].m_marks);

        BubbleSort.bubbleSort(students);
        MergeSort.sort(students, 0, students.length - 1);


        // The constructor Integer(int) has been deprecated since version 9 and marked for removal
        Integer i = new Integer(10);

        // unboxing the Object
        int i1 = i;

        System.out.println("\nUnboxing the Integer Object: ");
        System.out.println("Value of i: " + i);
        System.out.println("Value of i1: " + i1);

        // The constructor Character(char) has been deprecated since version 9 and marked for removal
        Character c = new Character('A');

        // Autoboxing the Object
        char c1 = c;
        System.out.println("\nAutoboxing the Character Object: ");
        System.out.println("Value of c: " + c);
        System.out.println("Value of c1: " + c1);
    }
}