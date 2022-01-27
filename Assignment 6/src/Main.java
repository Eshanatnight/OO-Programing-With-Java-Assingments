class Dog
{
    String name;

    public Dog(String name)
    {
        this.name = name;
    }

}

public class Main
{
    public static void main(String[] args)
    {
        Dog dog = new Dog("Fido");
        Dog dog2 = dog;
        System.out.println(dog.name);
        System.out.println(dog2.name);
        foo(dog);
        System.out.println(dog.name);
        System.out.println(dog2.name);
    }

    public static void foo(Dog goodboi)
    {
        System.out.println(goodboi.name.equals("Fido"));
        goodboi = new Dog("Fifi");
        System.out.println(goodboi.name.equals("Fifi"));
    }
}
