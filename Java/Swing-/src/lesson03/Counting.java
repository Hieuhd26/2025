package lesson03;

public class Counting extends Thread {

    private boolean isStop = false;
    private static int count = 0;

    @Override
    public void run() {
        while (!isStop) {
            count++;
            if (isStop == true) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void end() {
        isStop = true;
    }

    public String getNumber() {
        return String.valueOf(count);
    }
}
