package com.csh.interview.threadloacalpractice.sleepandwait;

/**
 * @author Chang ShiHao
 * @version 1.0
 * @date 2024/3/9 16:48
 */
public class TestSleepAndWait {

    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("sleep end");

        Object obj = new Object();
        synchronized (obj){
            obj.wait(2000);
            System.out.println("wait end");
        }

    }
}
