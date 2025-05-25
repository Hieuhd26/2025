package lesson02;

import javax.swing.*;
import java.awt.*;

public class ColoredWindow extends JFrame {
    public static final int WIDTH = 300;
 public static final int HEIGHT = 200;

    public ColoredWindow(Color theColor) throws HeadlessException {
        super("No Charge for Color");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(theColor);

        JLabel aLabel = new JLabel("Close-window button works.");
        add(aLabel);
    }

    public ColoredWindow() throws HeadlessException {
        this(Color.BLUE);
    }
}
