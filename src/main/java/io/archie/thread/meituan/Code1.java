package io.archie.thread.meituan;

import java.util.concurrent.*;

/**
 * 有返回结果的多线程之间互相调度
 * <p>
 * 使用CompletableFuture编排 AService.get()、BService.get()、CService.get(int i) （ABC三个服务返回结果都是int），
 * 满足使用A、B的结果相加，再作为参数传给C，取得C的结果后乘以 100 后返回。
 * 要求：
 * <p>
 * 1. 显示指定线程池
 * 2. 处理异常情况，异常情况返回0。
 */
public class Code1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 3, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        CompletableFuture<Integer> taskA = CompletableFuture.supplyAsync(AService::get, executorService);
        CompletableFuture<Integer> taskB = CompletableFuture.supplyAsync(BService::get, executorService);

        CompletableFuture<Integer> combinedFuture = taskA.thenCombine(taskB, Integer::sum)
                .thenCompose(result -> CompletableFuture.supplyAsync(() -> CService.get(result), executorService));

        try {
            int finalResult = combinedFuture.get();
            System.out.println(finalResult * 100);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static class AService {
        public static int get() {
            return 1;
        }
    }

    public static class BService {
        public static int get() {
            return 2;
        }
    }

    public static class CService {
        public static int get(int i) {
            return 1 + i;
        }
    }
}
