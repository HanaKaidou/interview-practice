package com.csh.threadtest.thread;

/**
 * @author Chang ShiHao
 * @version 1.0
 * @date 2023/11/7 13:38
 */
public class Student extends Thread {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Student().start();
            System.out.println("这是main" + (i + 1) + "方法");
        }
    }

    @Override
    public void run() {
        System.out.println("这是run方法");
    }
}
