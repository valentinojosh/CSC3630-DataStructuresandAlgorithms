import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class pokemonAutoSteps {
    public static void main(String args[]) throws IOException, AWTException, InterruptedException {

        //couldnt get the run command to work, so i swapped it
        // for a mouse click to the cords of the program already open
//        String command = "/Users/josh/Desktop/Clean/Games/OpenEmu.app";

        //This command actually opens openemu, however, it seems to crash when i open it from there
//        String command = "/Users/josh/Desktop/Clean/Games/OpenEmu.app/Contents/MacOS/OpenEmu";
//        Runtime run = Runtime.getRuntime();
//        run.exec(command);

        try {
        //delay 4ms
            Thread.sleep(40);
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //creating a constructor of the Robot class
        Robot robot = new Robot();
        //pressing key by invoking the keyPress() method
        //delay of 5 miliseconds after each key press

        //These x coordinate is subject to change based upon amount of applications in the dock
//        moveMouseTo(1182, 870);
//        clickApplication(robot);
//        runBackAndForth(robot);
    }

    private static void runBackAndForth(Robot robot) throws InterruptedException {
//        for(int i = 0; i < 100; i++){
//            robot.keyPress(KeyEvent.VK_D);
//            Thread.sleep(100);
//            robot.keyRelease(KeyEvent.VK_D);
//        }
//        Thread.sleep(500);
//        robot.keyPress(KeyEvent.VK_D);
//        Thread.sleep(500);
//        robot.keyPress(KeyEvent.VK_A);
    }

    private static void clickApplication(Robot robot) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    private static void moveMouseTo(int x, int y)
    {
        try
        {
            Robot robot = new Robot();
            int xi1, yi1, xi, yi;
            //get initial location
            Point p = MouseInfo.getPointerInfo().getLocation();
            xi = p.x;
            yi = p.y;
            //get x and y points
            xi1 = x;
            yi1 = y;
            int i = xi, j = yi;
            //move the mouse to detained location
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
            }
        }
        catch (Exception evt)
        {
            System.err.println(evt.getMessage());
        }
    }

}
