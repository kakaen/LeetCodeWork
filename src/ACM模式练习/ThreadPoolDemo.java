package ACM模式练习;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPools = new ThreadPoolExecutor(
                3,
                4,
                100L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        threadPools.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        });
    }
}
