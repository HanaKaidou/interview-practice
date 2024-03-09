package com.csh.interview.threadloacalpractice.threadexcutesort;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Chang ShiHao
 * @version 1.0
 * @date 2024/3/9 22:27
 */
public class TestSingleThreadPool {

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " t1 start");
        }, "t1");
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " t2 start");
        }, "t2");
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " t3 start");
        }, "t3");


        THREAD_POOL_EXECUTOR.execute(t1);
        THREAD_POOL_EXECUTOR.execute(t2);
        THREAD_POOL_EXECUTOR.execute(t3);
    }
}
