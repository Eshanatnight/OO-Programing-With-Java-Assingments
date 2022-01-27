class ThreadDemo implements Runnable
{
    Thread thread;

    void doSomething()
    {
        for (int i = 5; i > 0; --i)
        {
            try
            {
                Thread.sleep(2);
            }
            catch (Exception e)
            {
                System.out.println("Thread Interrupted.");
            }
            System.out.println("Thread Name: " + thread.getName() + " Count: " + i);
        }
    }

    @Override
    public void run()
    {
        synchronized(this)
        {
            doSomething();
        }
    }

    public void start(String threadName)
    {
        if(thread == null)
        {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    public void join()
    {
        try
        {
            thread.join();
        }
        catch(Exception e)
        {
            System.out.println(thread.getName() + "Thread  interrupted.");
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        ThreadDemo T1 = new ThreadDemo();
        ThreadDemo T2 = new ThreadDemo();

        T1.start("ThreadOne");
        T2.start("ThreadTwo");

        try
        {
            T1.join();
            T2.join();
        }
        catch(Exception e)
        {
            System.out.println("Interrupted");
        }
    }
}
