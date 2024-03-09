package com.csh.interview.threadloacalpractice.sleepandwait;

/**
 * @author Chang ShiHao
 * @version 1.0
 * @date 2024/3/9 16:48
 */
public class TestSleepAndWait1 {

    public static final Object obj = new Object();

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            synchronized (obj) {
                System.out.println("notify开始");
                obj.notify();
                System.out.println("notify结束");
            }
        }).start();

        synchronized (obj) {
            System.out.println("wait 之前");
            obj.wait();
            System.out.println("wait 之后");
        }


//另一种写法
//        //保证等待和通知是同一个对象
//        //第一个线程进行wait
//        Thread t1 = new Thread(() ->{
//            while(true){
//                synchronized (obj){//上锁
//                    System.out.println("wait 之前");
//                    try {
//                        obj.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("wait 之后");
//                }
//            }
//        });
//        t1.start();
//        //第二个线程,进行notify
//        Thread t2 = new Thread(() -> {
//            while (true) {
//                synchronized (obj) {
//                    System.out.println("notify 之前");
//                    obj.notify();
//                    System.out.println("notify 之后");
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t2.start();


    }
}
