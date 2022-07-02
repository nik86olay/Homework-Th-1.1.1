import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<Integer>> task = new ArrayList();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService threadPool = Executors.newFixedThreadPool(4, x -> new Thread(x, "Поток " + atomicInteger.addAndGet(1)));
        for (int i = 1; i < 5; i++) {
            task.add(new MyTask(i));
        }

        // запуск для выполнения всех задач
        threadPool.invokeAll(task).stream().map(future -> {
            try {
                return future.get();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }).forEach(x -> System.out.println("количество выведенных потоком сообщений в консоль - " + x));
        System.out.println();

        // запуск для выполнения самой быстрой задачи
        try {
            Integer result = threadPool.invokeAny(task);
            System.out.println("количество выведенных потоком сообщений в консоль - " + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // закрытие пула потоков
        threadPool.shutdown();
    }
}
