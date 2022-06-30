import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<String>> task = new ArrayList();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 1; i < 5; i++) {
            task.add(new MyThread(i));
        }

        // запуск для выполнения всех задач
        threadPool.invokeAll(task).stream().map(future-> {try {
            return future.get();
        }catch (Exception e) {
            throw new IllegalStateException(e);
        }
        }).forEach(System.out::println);
        System.out.println();

        // запуск для выполнения самой быстрой задачи
        try {
            String rezult = threadPool.invokeAny(task);
            System.out.println(rezult);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // закрытие пула потоков
        threadPool.shutdown();
    }
}
