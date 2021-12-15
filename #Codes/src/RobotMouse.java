import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class RobotMouse extends Frame implements ActionListener
{
    //Frame
    static JFrame frame;
    //textField
    static TextField x, y;
    //creating a default constructor
    RobotMouse()
    {
    }
    //main method
    public static void main(String args[])
    {
//creating an object of the class
        RobotMouse rm = new RobotMouse();
//creating a frame
        frame = new JFrame("MouseSimulation");
//set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//creating textfield
        x = new TextField(7);
        y = new TextField(7);
//creating a button
        Button btn = new Button("OK");
//add actionListener to the OK button
        btn.addActionListener(rm);
//creating an object of the panel class
        Panel p = new Panel();
//add button, text fields to the panel
        p.add(x);
        p.add(y);
        p.add(btn);
        frame.add(p);
//set the frame size
        frame.setSize(300, 300);
        frame.show();
    }
    //if button is pressed
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            Robot robot = new Robot();
            int xi1, yi1, xi, yi;
//get initial loction
            Point p = MouseInfo.getPointerInfo().getLocation();
            xi = p.x;
            yi = p.y;
//get x and y points
            xi1 = Integer.parseInt(x.getText());
            yi1 = Integer.parseInt(y.getText());
            int i = xi, j = yi;
//slowly move the mouse to detained location
            while (i != xi1 || j != yi1)
            {
//move the mouse to the other point
                robot.mouseMove(i, j);
                if (i < xi1)
                    i++;
                if (j < yi1)
                    j++;
                if (i > xi1)
                    i--;
                if (j > yi1)
                    j--;
//sleeps the cursor for 30ms
                Thread.sleep(0);
            }
        }
        catch (Exception evt)
        {
            System.err.println(evt.getMessage());
        }
    }
}