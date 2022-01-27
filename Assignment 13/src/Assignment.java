import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

class MonthCalender
{
    // Variable of Type Calendar
    private Calendar cal;

    // Variable that keeps track of today's date
    private int today;

    // Variable That keeps track of the month
    private int month;

    // Variable to keep track of the day of the week
    private int weekday;

    // Variable to Keep Track of the First Day of the Week
    private int firstDayOfWeek;

    // An Array of Strings that keeps the name of the days of the week in order
    private String[] weekdays;

    // Variable that keeps track of the indent For the first line of the calendar
    private int numberOfIndents;


    // Constructor to initialize the class
    public MonthCalender()
    {
        // Initializes the Calendar as a Gregorian Calendar
        cal = new GregorianCalendar();

        // Get the today's date
        today = cal.get(Calendar.DAY_OF_MONTH);

        // Get current month
        month = cal.get(Calendar.MONTH);
    }

    /*
        * Prints The Year and Month
        * Before printing the calendar
    */
    private void printCalenderInformation()
    {
        System.out.println("Calender Year: " + cal.get(Calendar.YEAR));
        System.out.println("Month: " + Month.from(LocalDate.now()).name() + "\n");
    }

    /*
        * A function that formats the first line of the dates in the calendar
        * with proper spacing.
        * @param indent : int - the number of spaces to indent the first line
    */
    private static void fmt_printIndents(int numberOfIndents)
    {
        System.out.println();

        for(int i = 0; i < numberOfIndents; i++)
        {
            System.out.print(" ");
        }
    }

    /*
    * A function that prints a marker on todays date
    * @param: day   : int - the date of the month
    * @param: today : int - todays date
    */
    private static void fmt_markToday(int day, int today)
    {
        if (day == today)
        {
            System.out.print("*");
        }

        else
        {
            System.out.print(" ");
        }
    }

    /*
        * A function to format the calendar at end of week
        * @param: weekday        : int - the day of the week
        * @param: firstDayOfWeek : int - the first day of the week
    */
    private static void fmt_endOfWeek(int weekday, int firstDayOfWeek)
    {
        if(weekday == firstDayOfWeek)
        {
            System.out.println();
        }
    }

    /*
        * Calculate the Number Of indents the first line of the calendar
        * should have. indent variable is incremented with 5 on each itteration
        * as the formating for the month is 5 spaces length-wise formatted.
        * Check Line NO. 137 for more info on string formating.
    */
    private void fmt_calculateAndSetIndents()
    {
        while ( weekday != firstDayOfWeek )
        {
            numberOfIndents+=5;
            cal.add(Calendar.DAY_OF_MONTH, -1);
            weekday = cal.get(Calendar.DAY_OF_WEEK);
        }
    }


    /*
        * Function to print the calendar of the Current Month
    */
    public void run()
    {
        // Print the Year and Month
        printCalenderInformation();

        // Set the first day of the week
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Get the current day of the week
        weekday = cal.get(Calendar.DAY_OF_WEEK);

        // Get the First day of the week
        firstDayOfWeek = cal.getFirstDayOfWeek();

        // Calculate the number of indents required for the first line of the calendar
        // Note: this function alters the weekday variable to the correct state
        fmt_calculateAndSetIndents();

        // Initialize the weekdays array with the names of the days of the week in order
        // egs: Sun, Mon, Tue, Wed, Thu, Fri, Sat
        weekdays = new DateFormatSymbols().getShortWeekdays();

        // Iterate and Print the Weekdays In Short Format "Sun"....
        do
        {
            // The String is formatted to be 5 spaces long.
            System.out.printf("%4s ", weekdays[weekday]);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            weekday = cal.get(Calendar.DAY_OF_WEEK);
        } while ( weekday != firstDayOfWeek );

        fmt_printIndents(numberOfIndents);

        // Reset the Calendar to the first day of the month
        cal.set(Calendar.DAY_OF_MONTH, 1);

        // Iterate Through the Days of the Month
        // And print the dates in the calendar.
        do
        {
            int day = cal.get(Calendar.DAY_OF_MONTH);

            // Print the date in the calendar. Type: INTEGER
            // Formatted to be 5 spaces long.
            System.out.printf("%4d", day);

            fmt_markToday(day, today);

            cal.add(Calendar.DAY_OF_MONTH, 1);
            weekday = cal.get(Calendar.DAY_OF_WEEK);

            fmt_endOfWeek(weekday, firstDayOfWeek);
        } while ( cal.get(Calendar.MONTH) == month );

        fmt_endOfWeek(weekday, firstDayOfWeek);
    }
}

public class Assignment
{
    public static void main(String[] args)
    {
        MonthCalender mc = new MonthCalender();
        mc.run();
    }
}