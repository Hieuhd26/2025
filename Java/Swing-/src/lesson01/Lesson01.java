package lesson01;

import javax.swing.*;

public class Lesson01 {
    public static final int WIDTH =300;
    public static final int HEIGHT =200;

    public static void main(String[] args) {
        JFrame firstWindow = new JFrame();
        firstWindow.setSize(WIDTH,HEIGHT);
        firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton endButton = new JButton("Click to end program.");
        EndingListener buttonEar = new EndingListener();
        endButton.addActionListener(buttonEar);

        firstWindow.add(endButton);

        firstWindow.setVisible(true);
    }
}
