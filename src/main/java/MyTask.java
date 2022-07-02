import java.util.concurrent.Callable;

import static java.lang.Thread.*;

public class MyTask implements Callable<Integer> {

    private final int numberMessages;
    private int messageCounter;

    public MyTask(int i) {
        this.numberMessages = i;
    }

    @Override
    public Integer call() {
        try {
            while (messageCounter != numberMessages) {
                System.out.println("Я " + currentThread().getName() + ". Всем привет!");
                messageCounter++;
                sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s завершен\n", currentThread().getName());
        }
        return messageCounter;
    }
}
