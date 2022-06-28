import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {
    int i = 0;

    @Override
    public Integer call() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
                i++;
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Поток %s завершен\n", Thread.currentThread().getName());
        }
        return i;
    }
}
