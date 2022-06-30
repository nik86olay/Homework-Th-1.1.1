import java.util.concurrent.Callable;
import static java.lang.Thread.*;

public class MyThread implements Callable<String> {
    private final int i;
    private int j;

    public MyThread(int i){
        this.i=i;
    }

    @Override
    public String call() {
        try {
            while (j!=i) {
                System.out.println("Я поток " + currentThread().getName() + ". Всем привет!");
                j++;
                sleep(300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Поток %s завершен\n", currentThread().getName());
        }
        return "количество выведенных потоком "+ currentThread().getName() +" сообщений в консоль - " +j;
    }
}
