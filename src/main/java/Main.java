import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<Future<Integer>> task = new ArrayList();
        MyThread myThread = new MyThread();
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

//        ThreadGroup threadGroup = new ThreadGroup("myThread");
//        final FutureTask <Integer> futureTask = new FutureTask<>(myThread);
        for (int i = 1; i < 5; i++) {
            task.add(myThread);
        }
        List<Future<MyThread>> ere = threadPool.submit(task);
//            Thread thread = new Thread(threadGroup, futureTask);
//
//            thread.setName(String.valueOf(i));
//            thread.start();
//        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
