/*
    Question: Write a program to create multiple threads by using thread class.
*/

class Counter extends Thread
{
    public static final int MAX_COUNT = 10;
    public static final int DELAY_IN_MILLISECONDS = 500;
    public Counter()
    {
        super("Counter Sub-Thread");
        System.out.println("New Thread Created\n" + this);
        System.out.println();
        start();
    }

    @Override
    public void run()
    {
        try
        {
            for(int i = 0; i < 10; ++i)
            {
                if( i % 2 == 0)
                    System.out.println();
                System.out.println("Printing " + (1 + i));
                Thread.sleep(DELAY_IN_MILLISECONDS);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread interrupted");
        }

        System.out.println("\nSub-Thread's run is over");
    }
}


public class Assignment
{
    public static void main(String[] args)
    {
        Counter count = new Counter();

        try
        {
            while(count.isAlive())
            {
                System.out.println("\nMain thread is live");
                Thread.sleep(Counter.DELAY_IN_MILLISECONDS * 2);
            }
        }

        catch (InterruptedException e)
        {
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nMain thread's run is over");
    }
}