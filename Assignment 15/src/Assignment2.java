class ThreadClass extends Thread
{
    private int number;

    public ThreadClass(int number)
    {
        this.number = number;
    }

    @Override
    public void run()
    {
        int counter = 0;
        int numInt = 0;

        // prints the number till specified number is reached, starting from 10
        do
        {
            numInt = (int) (counter);
            System.out.println(this.getName() + " prints Hello World " + numInt);
            counter++;
        } while(numInt != number);
        System.out.println("## SUCCESSFUL! " + this.getName() + " printed " + counter + " times. ##");
    }
}

public class Assignment2
{
    public static void main(String [] args)
    {
        System.out.println("Starting thread_1...");
        //create a thread class instance
        Thread thread_1 = new ThreadClass(4);
        //start the thread thread_1
        thread_1.start();
        try
        {
            //wait for thread_1 to join to main thread
            thread_1.join();
        }

        catch (InterruptedException e)
        {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Starting thread_2...");

        Thread thread_2 = new ThreadClass(6);

        //start thread_2
        thread_2.start();

        System.out.println("main() is ending...");
    }
}