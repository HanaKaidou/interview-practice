package com.csh.interview.threadloacalpractice.threadexcutesort;

/**
 * @author Chang ShiHao
 * @version 1.0
 * @date 2024/3/9 22:15
 */
public class TestJointhread {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("线程1");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程2");
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程3");
        });

        t1.start();
        t2.start();
        t3.start();

    }

}
