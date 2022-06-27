public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadGroup threadGroup = new ThreadGroup("myThread");
        for (int i = 1; i < 5; i++) {
            Thread thread = new Thread(threadGroup, myThread);
            thread.setName(String.valueOf(i));
            thread.start();
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadGroup.interrupt();

    }
}
