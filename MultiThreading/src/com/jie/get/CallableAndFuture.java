package com.jie.get;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
// 定义任务:
        Callable<String> task = new Task();
// 提交任务并获得Future:
        Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
        String result = future.get(); // 可能阻塞

        System.out.println(result);

    }
}


class Task implements Callable<String> {
    public String call() throws Exception {
        return LocalDateTime.now().toString();
    }
}



/*

get()：获取结果（可能会等待）
get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
cancel(boolean mayInterruptIfRunning)：取消当前任务；
isDone()：判断任务是否已完成。

 */