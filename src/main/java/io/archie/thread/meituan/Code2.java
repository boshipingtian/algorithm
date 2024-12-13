package io.archie.thread.meituan;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 用多线程实现生产者、消费者模型
 * <p>
 * 编写一个队列，生产者生产消息（消息内容是1,2,3,...,n），消费者消费消息，并将消息打印到控制台。 要求：
 * <p>
 * 生产者以每秒10个的速率生产消息，队列满了后阻塞等待；
 * 队列长度为100；
 * 消费者以每秒1个的速率消费消息；
 * 生产者和消费者在不同的线程；
 */
public class Code2 {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(100);

        new Thread(()->new Consumer(queue).get()).start();
        new Thread(()->new Consumer(queue).get()).start();
        new Thread(()->new Consumer(queue).get()).start();
        new Thread(()->new Provider(queue).put()).start();

    }

    public static class Consumer {

        public final LinkedBlockingQueue<Integer> queue;

        public Consumer(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public Integer get() {
            while (true) {
                try {
                    Integer take = queue.take();
                    System.out.println(Thread.currentThread().getName() + ": take = " + take);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static class Provider {

        public final LinkedBlockingQueue<Integer> queue;

        public Provider(LinkedBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void put() {
            int i = 0;
            while (true) {
                try {
                    for (int j = 0; j < 10; j++) {
                        queue.put(i++);
                        System.out.println(Thread.currentThread().getName() + " : 添加了" + i);
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
