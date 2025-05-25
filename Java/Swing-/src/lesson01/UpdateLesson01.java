package lesson01;

import javax.swing.*;
import java.awt.*;

public class UpdateLesson01 extends JFrame {
    public static final int WIDTH =300;
    public static final int HEIGHT =200;

    public UpdateLesson01() throws HeadlessException {
        super("First Window");
        //setTitle("First Window Class");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton endButton = new JButton("Click to end program.");
        endButton.addActionListener(new EndingListener());
        add(endButton);
    }
}
