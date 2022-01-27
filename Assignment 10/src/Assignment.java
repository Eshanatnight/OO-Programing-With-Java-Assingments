interface A
{
    void Hello();
}

interface B
{
    void Goodbye();
}

abstract class C
{
    void NiceToMeetYou()
    {
        System.out.println("Nice To Meet You from Abstract \"Class C\"");
    }
}

class D extends C implements A, B
{

@Override
    public void Hello()
    {
        System.out.println("Hello");
    }

@Override
    public void Goodbye()
    {
        System.out.println("Goodbye");
    }

@Override
    public void NiceToMeetYou()
    {
        System.out.println("Nice To Meet You from Class \'D\'");
    }
}

public class Assignment
{


    public static void main(String[] args)
    {
        D d = new D();
        d.Hello();
        d.Goodbye();
        d.NiceToMeetYou();
    }
}