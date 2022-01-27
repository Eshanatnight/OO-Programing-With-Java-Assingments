class RunnableInterface implements Runnable
{
    Thread thread;

    RunnableInterface()
    {
        thread = new Thread(this, "Child Thread");

        // This Print Statement is just for debug purpose.
        System.out.println("Child Thread is: " + thread);
        thread.start();
    }

    @Override
    public void run()
    {
        // This Print Statement is just for debug purpose.
        System.out.println("New Child Thread Running");

        try
        {
            Thread.sleep(100);
        }

        catch (InterruptedException e)
        {
            System.out.println("Child Thread is Interrupted" + e.getLocalizedMessage());
        }

    }

    void setPriority(int priority)
    {
        // This Print Statement is just for debug purpose.
        System.out.println("Child Thread Priority Set.");
        thread.setPriority(priority);
    }

    int getPriority()
    {
        return thread.getPriority();
    }

    boolean isAlive()
    {
        return thread.isAlive();
    }

    void start()
    {
        thread.start();
    }

    void join()
    {
        try
        {
            thread.join();
        }

        catch (InterruptedException e)
        {
            System.out.println("Child Thread is Interrupted" + e.getLocalizedMessage());
        }

        // This Print Statement is just for debug purpose.
        System.out.println("Child Thread Joined");
    }

}

public class Assignment2
{
    public static void main(String[] args)
    {
        RunnableInterface runnableInterface1 = new RunnableInterface();
        RunnableInterface runnableInterface2 = new RunnableInterface();

        runnableInterface1.setPriority(4);
        runnableInterface2.setPriority(7);

        System.out.println("Priority of thread is: " + runnableInterface1.getPriority());
        System.out.println("Priority of thread is: " + runnableInterface2.getPriority());

        System.out.println("Child Thread is Alive: " + runnableInterface1.isAlive());
        System.out.println("Child Thread is Alive: " + runnableInterface2.isAlive());

        runnableInterface1.join();
        runnableInterface2.join();

        // This Print Statement is just for debug purpose.
        System.out.println("Main Thread Completed");
    }

}
