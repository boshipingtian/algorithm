package io.archie.algorithm.test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/27 15:52
 */
public class ThreadLocalDemo implements Runnable {
    
    private final CountDownLatch countDownLatch;

    public static final ThreadLocal<List<String>> holder = new ThreadLocal<>();

    public ThreadLocalDemo(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) throws InterruptedException {
        int total = 10;
        CountDownLatch countDownLatch = new CountDownLatch(total);
        for (int i = 0; i < total; i++) {
            Thread thread = new Thread(new ThreadLocalDemo(countDownLatch));
            thread.start();
        }
        countDownLatch.await();
    }
    
    @Override
    public void run() {
        holder.set(Arrays.asList("1","2", "3"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        holder.get().forEach(s -> System.out.println(Thread.currentThread().getName() + ": " + s));
        countDownLatch.countDown();
    }
}