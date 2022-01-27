/*
    Question[1]: Write a program to create multiple threads by implementing Runnable interface.
    Question[2]: Use join(), isAlive(), getPriority(), SetPriority() methods.
*/

class RunnableInterface implements Runnable
{
    Thread thread;
    int counter;
    static final int DELAY_MILLIS = 500;

    public RunnableInterface()
    {
        System.out.println("Child Thread Running");
        thread = new Thread(this, "Child Thread");
        System.out.println("Child Thread is: " + thread);
        thread.start();
    }


    @Override
    public void run()
    {
        try
        {
            for(counter = 1; counter <= 5; ++counter)
            {
                Thread.sleep(DELAY_MILLIS / 6);
                System.out.println("Child Thread Counter: " + counter);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Child Thread is Interrupted");
        }
        System.out.println("Child Thread Completed");
    }


}

public class Assignment
{
    private static void runThreadImplementTest()
    {
        new RunnableInterface();

        try
        {
            for(int i = 1; i <= 5; ++i)
            {
                Thread.sleep((RunnableInterface.DELAY_MILLIS));
                System.out.println("Main Thread: " + i);
            }
        }

        catch (InterruptedException e)
        {
            System.out.println("Main Thread Interrupted");
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Main Thread Running");
        runThreadImplementTest();
        System.out.println("Main Thread Completed");
    }
}