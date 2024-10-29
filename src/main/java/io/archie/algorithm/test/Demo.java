package io.archie.algorithm.test;

/**
 * <br>
 *
 * @Author: MrArchie
 * @Date: 2024/10/27 14:34
 */
public class Demo {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("start 3 thread");
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread1 = new Thread(runnableDemo);
        thread1.start();
        thread1.join();
        System.out.println("end 3 thread");

    }

    public static class RunnableDemo implements Runnable {

        public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

        public RunnableDemo() {
            THREAD_LOCAL.set(Thread.currentThread().getName());
        }
        
        @Override
        public void run() {
            THREAD_LOCAL.set(Thread.currentThread().getName());
            System.out.println(THREAD_LOCAL.get());
        }
    }
}