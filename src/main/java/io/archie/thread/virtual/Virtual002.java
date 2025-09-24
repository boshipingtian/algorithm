package io.archie.thread.virtual;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 创建虚拟线程的方法
 */
public class Virtual002 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        virtual();
        long end = System.currentTimeMillis();
        System.out.printf("time virtual = %d\n", (end - start));
        start = System.currentTimeMillis();
        real();
        end = System.currentTimeMillis();
        System.out.printf("time real = %d\n", (end - start));
    }

    public static void virtual() throws InterruptedException {
        // 通过 ThreadFactory 创建
        ThreadFactory factory = Thread.ofVirtual().factory();
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            factory.newThread(() -> {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        latch.countDown();
                    })
                    .start();
        }
        latch.await();
    }

    public static void real() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        CountDownLatch latch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            service.submit(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                latch.countDown();
            });
        }
        latch.await();
        service.shutdown();
    }
}
