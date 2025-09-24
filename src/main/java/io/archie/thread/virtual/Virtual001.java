package io.archie.thread.virtual;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 创建虚拟线程的方法
 */
public class Virtual001 {

    public static void main(String[] args) {
        // 1. 通过 Thread.ofVirtual() 创建
        Runnable fn = () -> System.out.println("hello");
        Thread.ofVirtual().start(fn);

        // 2.通过 Thread.startVirtualThread()创建
        Thread.startVirtualThread(fn);

        // 3. 通过 Executors.newVirtualThreadPerTaskExecutor() 创建
        var executorService = Executors.newVirtualThreadPerTaskExecutor();
        executorService.submit(fn);

        // 4. 通过 ThreadFactory 创建
        ThreadFactory factory = Thread.ofVirtual().factory();
        Thread thread = factory.newThread(fn);
        thread.start();
    }
}
