// Class to store the Coordinates on an Entity in an 3D Real Space
class Vec3
{
    public float x, y, z;

    public Vec3(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Vec3(Vec3 v)
    {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public boolean compareTo(Vec3 other)
    {
        return (this.x == other.x && this.y == other.y && this.z == other.z);
    }

    public float calculateDistance()
    {
        return (float)Math.sqrt(x * x + y * y + z * z);
    }

    public Vec3 normalize()
    {
        float norm = calculateDistance();
        return new Vec3(x / norm, y / norm, z / norm);
    }

    public Vec3 move(Vec3 velocityVec3, float time)
    {
        return new Vec3(x + velocityVec3.x * time, y + velocityVec3.y * time, z + velocityVec3.z * time);
    }
}

class Entity
{
    private String m_name = "";
    private final String m_state = "Non-Bianry";
    private Vec3 m_position = new Vec3(0, 0, 0);

    // Constructor for the Entity Class
    public Entity(String name, Vec3 pos)
    {
        this.m_name = name;
        this.m_position = pos;
    }

    // Setter for the name of the entity
    // Incase the entity name is changed
    // Since the m_name field is not final (mutable)
    // we can easily alter the field as mnay time we want
    void setName(String name)
    {
        this.m_name = name;
    }

/*
    @error:
            ``` error: cannot assign a value to final variable m_state
                this.m_state = state; ```

    @brief: When we try to re-set the state string we get an error
    as the final keyword makes the m_state string non resetable and
    hence cannot be altered after initializing it

    @param: String state
    @return: void

    void setState(String state)
    {
        this.m_state = state;
    }
*/
    public String toString()
    {
        return ("Name: " + m_name + "\tState: " + m_state + "\tPosition: (" + m_position.x + ", " + m_position.y + ", " + m_position.z +")");
    }
}

public class Assignment3
{
    public static void main(String[] args)
    {

        System.out.println("Useage Via The final Keyword: \n\n");

        // Create an Entity Object
        Entity entity = new Entity("Entity", new Vec3(0, 0, 0));

        // Before Using Any Methods
        // Print the Entity Object
        System.out.println(entity.toString());

        // Set a new name for the created entity
        // Since the name is reset we can change it
        entity.setName("Kells");

        // Print the Entity after allterations
        System.out.println(entity.toString());

        /*
            @error:
                    ``` error: cannot assign a value to final variable m_state
                        entity.m_state = "Binary"; ```
            @brief: When we try to re-set the state string we get an error
            as the final keyword makes the m_state string non reinitializeable

        entity.setState("Binary");
        System.out.println(entity.toString());

        */


        System.out.println("\n\nTo Check the Immutablity of Strings: ");

        // Now We take a String
        // then we use the concat method to add the string
        String name = "Kells";
        System.out.println("Name: " + name);
        System.out.println("Name with the concat method: " + name.concat("atnight"));

        // But we see that even after the concat method
        // the name string keeps its original Value
        // Hence String is immutable
        System.out.println("Name: " + name);

        System.out.println("\n\nTo Check the Mutablity of the StringBuffer Class: ");

        // Now Lets try the Same thing with The StringBuffer
        StringBuffer nameBuffer = new StringBuffer("Kells");

        // useage of toString() method is not necessary
        // but i still used it for clarity
        System.out.println("Name: " + nameBuffer.toString());

        // Lets append to the StringBuffer Object via the append Method
        nameBuffer.append("atnight");

        // Now we see that the StringBuffer Object has changed
        // From : "Kells"
        // To   : "Kellsatnight"
        System.out.println("Name: " + nameBuffer.toString());

    }

}