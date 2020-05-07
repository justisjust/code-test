package com.hzb.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-13 13:51
 * @Version 1.0
 */
public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i =0;
            while (true) {
                i++;
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println(i);
                    break;
                }
            }
        }, "dd");

        System.out.println("before: " + t1.isInterrupted());
        t1.start();
        TimeUnit.SECONDS.sleep(1);
//        t1.interrupt();
        System.out.println("after: " + t1.isInterrupted());
    }
}
