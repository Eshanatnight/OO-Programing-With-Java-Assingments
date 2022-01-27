/*
    Question: Create a GUI program which has 4 buttons assigned to colors Red, Green, Blue and Reset.
    When a button is pressed appropriate color should be displayed.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.LayoutManager;
import java.awt.Color;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class GUI_API_SWING implements ActionListener
{
    // Creates Four Buttons
    JButton red;
    JButton pink;
    JButton blue;
    JButton green;
    JButton reset;

    // Create A Frame
    JFrame frame;

    private static final int X_OFFSET = 10;

    public GUI_API_SWING()
    {
        // Initialize the frame Pannel
        frame = new JFrame("Color Changing GUI with SWING");

        // Initialize the Buttons
        red = new JButton("Red");
        blue = new JButton("Blue");
        green = new JButton("Green");
        reset = new JButton("Reset");
        pink = new JButton("Pink");

        // Set the size and location of the buttons
        // OFFSET var is used to offset the buttons
        // If you don't want deal with offsets set the frame Layout as
        // "frame.setLayout(new FlowLayout());"
        red.setBounds(50, 135, 100, 50);
        blue.setBounds(150 + X_OFFSET, 135, 100, 50);
        green.setBounds(250 + (2 * X_OFFSET), 135, 100, 50);
        pink.setBounds(350 + (3 * X_OFFSET), 135, 100, 50);
        reset.setBounds(450 + (4 * X_OFFSET), 135, 100, 50);

        // Add the buttons to the frame
        frame.add(red);
        frame.add(blue);
        frame.add(green);
        frame.add(pink);
        frame.add(reset);

        // ADD THE ACTION LISTENERS
        red.addActionListener(this);
        pink.addActionListener(this);
        green.addActionListener(this);
        blue.addActionListener(this);
        reset.addActionListener(this);

        setFrameBehaviour(650, 400, true, JFrame.EXIT_ON_CLOSE, null);
    }



    /*  Set the Frame Behaviour
        @param frame_width: Width of the Frame
        @param frame_height: Height of the Frame
        @param is_visible: If the Frame is visible or not
        @param exit_behaviour: The behaviour of the frame when closed
        @param layout: The Layout of the Frame(null if you don't want to set the layout)
    */
    private void setFrameBehaviour(int frame_width, int frame_height, boolean isVisible, int Jframe_EXIT_ENUM, LayoutManager manager)
    {
        // Frame properties are SET
        frame.setSize(frame_width, frame_height); // set the size of the frame TEST: 575, 400
        frame.setLayout(manager); // set the layout of the frame
        frame.setVisible(isVisible); // set the frame to be visible

        frame.setDefaultCloseOperation(Jframe_EXIT_ENUM); // When the close Button is pressed, the program will close
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String clicked = e.getActionCommand();
        // Console Logs the button that was clicked
        System.out.println("In SWING App:" + clicked + " button clicked");

        // SET COLORS ACCORDINGLY
        // Wanted to try using switch case but it didn't work
        // Probably because the buttons are custom objects
        // Maybethere is some way i can still use the switch case
        // for pattern matching??

        // Wanted to use a Hexadecimal Color Code
        // So added an extra button for pink
        // i really like the pink color
        if (e.getSource() == pink)
            frame.getContentPane().setBackground(Color.getColor("pink",0xff2070));

        else if (e.getSource() == blue)
            frame.getContentPane().setBackground(Color.blue);

        else if (e.getSource() == green)
            frame.getContentPane().setBackground(Color.green);

        else if (e.getSource() == blue)
            frame.getContentPane().setBackground(Color.blue);

        else if (e.getSource() == reset)
            frame.getContentPane().setBackground(Color.WHITE);

        else if (e.getSource() == red)
            frame.getContentPane().setBackground(Color.red);
    }

}


class GUI_API_AWT extends WindowAdapter implements ActionListener
{
    // Creates Four Buttons
    Button red;
    Button pink;
    Button blue;
    Button green;
    Button reset;

    // Create A Frame
    Frame frame;

    public GUI_API_AWT()
    {
        // Initailize the Buttons
        red   = new Button("Red");
        pink  = new Button("Pink");
        green = new Button("Green");
        blue  = new Button("Blue");
        reset = new Button("Reset");

        frame = new Frame("Color Changing GUI with AWT");
        // Passing a flow layout to the frame because i dont want to deal with offsets
        setFrameBehaviour(400, 400, true, new FlowLayout());

		//Add Buttons
		frame.add(red);
		frame.add(green);
		frame.add(blue);
        frame.add(pink);
		frame.add(reset);

		//Add Action Listeners
		red.addActionListener(this);
        pink.addActionListener(this);
		green.addActionListener(this);
		blue.addActionListener(this);
		reset.addActionListener(this);

        // Add a Window Listener to the frame
        frame.addWindowListener(this);
    }

    private void setFrameBehaviour(int frame_width, int frame_height, boolean isVisible, LayoutManager manager)
    {
        // Frame properties are SET
        frame.setSize(frame_width, frame_height); // set the size of the frame TEST: 575, 400
        frame.setLayout(manager); // set the layout of the frame
        frame.setVisible(isVisible); // set the frame to be visible
    }

    @Override
    public void windowClosing (WindowEvent e)
    {
        frame.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String clicked = e.getActionCommand();
        System.out.println("In AWT App: " + clicked + " button clicked");

        // SET COLORS ACCORDINGLY

        if (e.getSource() == red)
            frame.setBackground(Color.red);

        else if (e.getSource() == pink)
            frame.setBackground(Color.getColor("pink",0xff2070));

        else if (e.getSource() == green)
            frame.setBackground(Color.green);

        else if (e.getSource() == blue)
            frame.setBackground(Color.blue);

        else
            frame.setBackground(Color.WHITE);
    }

}
class GUI
{

    public static void displayWithAWT()
    {
        GUI_API_AWT gui = new GUI_API_AWT();
    }

    public static void displayWithSwing()
    {
        GUI_API_SWING gui = new GUI_API_SWING();
    }
}

public class Assignment
{

    public static void main(String[] args)
    {
        // Probalby i should not use the constructor
        // to run the GUI. But rather create a run function.
        // But i think it is fine for now.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to use AWT or Swing?");
        System.out.println("1. AWT");
        System.out.println("2. Swing");
        try
        {
            String choice = reader.readLine();

            switch (choice)
            {
                case "1":
                    GUI.displayWithAWT();
                    break;

                case "2":
                    GUI.displayWithSwing();
                    break;

                default:
                {
                    System.out.println("Invalid Choice");
                    System.out.println("Activating Both GUI's");
                    System.out.println("NOTE: The Console Logs will have similar output");
                    System.out.println("So Please read the Console Logs carefully");
                    System.out.println();
                    GUI.displayWithAWT();
                    GUI.displayWithSwing();
                    break;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading input" + e.getMessage());
        }

    }

}
