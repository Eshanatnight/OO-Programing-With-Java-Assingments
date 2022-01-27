package com.kells;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This is our GUI class. It extends JFrame and implements ActionListener.
class CalculatorGUI extends JFrame implements ActionListener
{
    // Declare our GUI components.
    // Panel for the buttons.
    JPanel panel;

    // Operator buttons
    // NoteForFuture Update: addition of a decimal point button
    JButton additionButton;
    JButton subtractionButton;
    JButton multiplicationButton;
    JButton divisionButton;
    JButton equalsButton;
    JButton clearButton;

    // Number buttons stored in an Array for easy of access (0 through 9)
    JButton[] numsButtons = new JButton[10];

    // Variables for storing the numbers and result
    double result;
    double firstNumber;
    double secondNumber;

    // Display Text Field
    JTextField textField;

    // char that stores the operator symbol
    char operator;


    // Explicit Default Constructor
    public CalculatorGUI()
    {
        /*
            * Call to the Super JFrame Constructor to set the title
            * Maybe pass the title as a parameter to the CalculatorGUI Constructor?
            * or Maybe passing the title as a RValue directly to the super constructor
            * Small String Optimizations might be possible but the compiler might not do it
            * as passing a string LValue to the super constructor might result in minor slowdowns?
        */
        super("Calculator");

        this.setLayout(new BorderLayout());

        // init panel
        initPanel(new GridLayout(4, 4));

        // init and bind buttons to the frame
        initAndBindButtons();

        // init the textField
        initTextField();

        // Bind the panel to the JFrame
        this.add(panel,BorderLayout.CENTER);

        // Bind the textField to the JFrame
        this.add(textField,BorderLayout.NORTH);

        // Sets the properties of the JFrame
        setFrameProperties(true,true, 500, 500, EXIT_ON_CLOSE);
    }


    /*
        * Overload to the Explicit Default Constructor
        * This is to allow for the use of the CalculatorGUI Constructor with more Customization and Control
        * @param title - The title of the JFrame; type -> String
        * @param isResizable - Whether the JFrame is Resizable or not; type -> boolean
        * @param isVisible - Whether the JFrame is Visible or not; type -> boolean
        * @param width - The width of the JFrame; type -> int
        * @param height - The height of the JFrame; type -> int
        * @param JFrameCloseOperationENUM - The operation to perform when the JFrame is closed; type -> int
    */
    public CalculatorGUI(String title, boolean isResizeable, int frameWidth, int frameHeight, int JFrameCloseOperationENUM)
    {
        // Call to the Super JFrame Constructor to set the title
        super(title);

        // Set the layout of the JFrame
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0x89CFF0));

        // init panel
        initPanel(new GridLayout(4, 4));

        // init and bind buttons to the Frame
        initAndBindButtons();

        // init the textField
        initTextField();

        // Bind the panel to the JFrame
        this.add(panel,BorderLayout.CENTER);

        // Bind the textField to the JFrame
        this.add(textField,BorderLayout.NORTH);

        // Sets the properties of the JFrame
        setFrameProperties(isResizeable, true, frameWidth, frameHeight, JFrameCloseOperationENUM);
    }


    /*
    * Initializes the panel with the passed layout
    * sets the background color of the panel
    * and sets the border of the panel
    * @param LayoutManager layout
    * @return void
    * Note: Might be better to pass the parameters of the GridLayout Constructor
    * cause the panel is always a GridLayout, Might cause minor Optimizations
    */
    private void initPanel(LayoutManager layout)
    {
        panel = new JPanel();
        panel.setLayout(layout);
        panel.setBackground(new Color(0x89CFF0));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }


    /*
        * Initializes all the buttons, binds them to the panel
        * and binds them to an action listener
        * @param void
        * @return void
    */
    private void initAndBindButtons()
    {
        // Initialize the JButtons -> NumberButtons
        initAndBindNumberButtons();

        // Initialize the JButtons -> OperatorButtons
        initAndBindOperatorButtons();
    }


    /*
    * Initializes the number buttons, adds them to the panel
    * attaches the action listener to the buttons, sets the color
    * of the buttons and fixes the size and style of the button text
    * @return void
    */
    private void initAndBindNumberButtons()
    {
        for(int i = 0; i <= 9; i++)
        {
            numsButtons[i] = new JButton(i+"");
            panel.add(numsButtons[i]);
            numsButtons[i].addActionListener(this);
            numsButtons[i].setBackground(new Color(0xFF4099));
            numsButtons[i].setFont(numsButtons[i].getFont().deriveFont(Font.BOLD, 20));
        }
    }


    /*
        * Initializes the operator buttons, adds them to the panel
        * attaches the action listener to the buttons, sets the color
        * of the buttons and fixes the size and style of the button text
        * @return void
    */
    private void initAndBindOperatorButtons()
    {
        additionButton = new JButton("+");
        panel.add(additionButton);
        additionButton.addActionListener(this);
        additionButton.setBackground(new Color(0xFF4099));
        additionButton.setFont(additionButton.getFont().deriveFont(Font.ITALIC, 20));

        subtractionButton = new JButton("-");
        panel.add(subtractionButton);
        subtractionButton.addActionListener(this);
        subtractionButton.setBackground(new Color(0xFF4099));
        subtractionButton.setFont(subtractionButton.getFont().deriveFont(Font.ITALIC, 20));

        multiplicationButton = new JButton("*");
        panel.add(multiplicationButton);
        multiplicationButton.addActionListener(this);
        multiplicationButton.setBackground(new Color(0xFF4099));
        multiplicationButton.setFont(multiplicationButton.getFont().deriveFont(Font.ITALIC, 20));

        divisionButton = new JButton("/");
        panel.add(divisionButton);
        divisionButton.addActionListener(this);
        divisionButton.setBackground(new Color(0xFF4099));
        divisionButton.setFont(divisionButton.getFont().deriveFont(Font.ITALIC, 20));

        equalsButton = new JButton("=");
        panel.add(equalsButton);
        equalsButton.addActionListener(this);
        equalsButton.setBackground(new Color(0xFF4099));
        equalsButton.setFont(equalsButton.getFont().deriveFont(Font.ITALIC, 20));

        clearButton = new JButton("Clear");
        panel.add(clearButton);
        clearButton.addActionListener(this);
        clearButton.setBackground(new Color(0xFF4099));
        clearButton.setFont(clearButton.getFont().deriveFont(Font.PLAIN, 20));
    }


    /*
        * sets the properties of the JFrame
        * @param boolean isResizable - whether the JFrame is resizable
        * @param boolean isVisible - whether the frame should be visible
        * @param int frameWidth - the width of the JFrame
        * @param int frameHeight - the height of the JFrame
        * @param int JFrameCloseOperationENUM - the operation to perform when the JFrame is closed
        * @return void
    */
    private void setFrameProperties(boolean isResizable, boolean isVisible, int frameWidth, int frameHeight, int JFrameCloseOperationENUM)
    {
        this.setBounds(100, 100, frameWidth, frameHeight);
        this.setResizable(isResizable);
        this.setVisible(isVisible);
        this.setSize(frameWidth, frameHeight);
        this.setDefaultCloseOperation(JFrameCloseOperationENUM);
    }


    /*
     * Instantiate the textField as a JTextField 10 Columns in length
     * set the background color to 0xfff8f8 (Cream White)
     * set the Border to a std::compoundBorder
     * set the font with size 20 and BOLD
     */
    private void initTextField()
    {
        // Initialize the JTextField
        textField = new JTextField(10);
        // Set the Background Color of the TextField
        textField.setBackground(new Color(0xFFF8F8));
        // Set the border properties of the TextField
        textField.setBorder(BorderFactory.createCompoundBorder(textField.getBorder(),
                            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        // Set the font properties of the TextField
        textField.setFont(textField.getFont().deriveFont(Font.BOLD, 20));
    }


    /*
        * Evaluates the operator for the operation
        * by checking which button was pressed by the user
        * @param pressedButton - The button that was pressed; type -> JButton
        * @return boolean - true or false depending on whether the operator was deduced or not
    */
    private Boolean getOperatorFlag(JButton pressedButton)
    {
        if(pressedButton == additionButton)
        {
            operator = '+';
            return true;
        }

        if(pressedButton == subtractionButton)
        {
            operator = '-';
            return true;
        }

        if(pressedButton == multiplicationButton)
        {
            operator = '*';
            return true;
        }

        if(pressedButton == divisionButton)
        {
            operator = '/';
            return true;
        }

        else                                      //  case where the operator is not deduced
        {
            return false;
        }
    }


    /*
     * Evaluates the expression based on the operator
     * Sets the result in the variable
     * @return void
     */
    void evaluate()
    {
        switch (operator)
        {
            case '+' -> result = firstNumber + secondNumber;
            case '-' -> result = firstNumber - secondNumber;
            case '*' -> result = firstNumber * secondNumber;
            case '/' -> result = firstNumber / secondNumber;
        }
    }


    /*
        * Parses the textField to get the number
        * @param pressedButton - The button that was pressed; type -> JButton
        * @return void
    */
    private void parseAndPrint(JButton pressedButton)
    {
        /*
            * Uses the Boolean Classes equals method rather than ! (not) operator
            * Something to do with the code style suggested by the Java Documentations
        */
        if(Boolean.FALSE.equals(getOperatorFlag(pressedButton)))
        {
            /*
                * Iterates through the buttons array then checks if
                * the button pressed is the same as one of button
                * in the numsButtons array, the for-each loop could have been used
                * But the classical for loop is used for the sake of readability
                * Because numButtons[i] is the button for the number represented by "i"

                Note: this loop can be moved to a separate method but the question
                remains is it necessary or even worth it?
            */
            for(int i = 0; i < 10; ++i)
            {
                if(pressedButton == numsButtons[i])
                {
                    String text = textField.getText();
                    text += i;
                    textField.setText(text);
                }
            }
        }

        /*
            * else parse the number in the textField and set
            * the text in the textField to an empty string
        */
        else
        {
            firstNumber = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }


    /*
     * Override for the getInsets method of the JFrame super class
     * This lets the JTextField be properly padded to in the JFrame
     * this get automatically called by the JFrame
     * @return Insets
     */
    @Override
    public Insets getInsets()
    {
        return new Insets(30, 10, 20, 10);
    }


/*
    * Function defines the action that is to be performed when the button is pressed
    * Override of the actionPerformed method in the ActionListener interface
    * @param ActionEvent ae - the event that is to be performed; type -> ActionEvent
    * @return void
*/
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        /*
            * Probably should use a String to store the response of the pressed button rather
            * than create a new JButton object. If done it might create minor optimizations
            * as we are comparing Strings rather than JButtons.
            * But also if proper small string optimizations are not done it might not be worth it
        */
        JButton pressedButton=(JButton)ae.getSource();

        if(pressedButton == clearButton)
        {
            result = firstNumber = secondNumber = 0;
            textField.setText("");
        }

        else if(pressedButton == equalsButton)
        {
            secondNumber = Integer.parseInt(textField.getText());
            evaluate();
            textField.setText("" + result);
        }

        else
        {
            parseAndPrint(pressedButton);
        }
    }
}


/*
    * The Public class Calculator interfaces with the Main function
    * The Main Function is defined in a separate file
    * Done so that we can activate the app without using a class object itself
*/
public class Calculator
{
    public static void initAndRunCalculator()
    {
        var app = new CalculatorGUI();
    }

    // Parameterized constructor
    public static void initAndRunCalculator(String title, boolean isResizeable, int frameWidth, int frameHeight, int JFrameCloseOperationENUM)
    {
        var app = new CalculatorGUI(title, isResizeable, frameWidth, frameHeight, JFrameCloseOperationENUM);
    }
}