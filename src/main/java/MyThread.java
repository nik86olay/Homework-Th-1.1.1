
public class MyThread implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Я поток " + Thread.currentThread().getName() + ". Всем привет!");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Поток %s завершен\n", Thread.currentThread().getName());
        }

    }
}
