package lesson02;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        ColoredWindow coloredWindow1 = new ColoredWindow();
        coloredWindow1.setVisible(true);

        ColoredWindow coloredWindow2 = new ColoredWindow(Color.PINK);
        coloredWindow2.setVisible(true);
    }
}
