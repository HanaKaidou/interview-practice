package com.csh.interview.threadloacalpractice.sleepandwait;

/**
 * @author Chang ShiHao
 * @version 1.0
 * @date 2024/3/9 16:48
 */
public class TestSleepAndWait2 {

    public static final Object obj = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (obj) {
                System.out.println("wait 之前");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("wait 之后");
            }
        }).start();

        synchronized (obj) {
            System.out.println("获取锁·····");
        }



    }
}
