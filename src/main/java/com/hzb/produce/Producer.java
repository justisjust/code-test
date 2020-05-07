package com.hzb.produce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description TODO
 * @Author haozhenbo
 * @Date 2020-04-22 17:52
 * @Version 1.0
 */
public class Producer {


    static int capacity = 5;

    public static List<Integer> list = new ArrayList<>(capacity);

    public static void write() {

        try {
            synchronized (list) {
                while (list.size() == capacity) {
                    System.out.println("容器已满");
                    list.wait();
                }
                int p = new Random().nextInt(500);
                Thread.sleep(1500);
                System.out.println("生产了一个对象" + p );
                list.add(p);
                list.notifyAll();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void read() {
        try {
            synchronized (list) {
                while (list.size() == 0) {
                    System.out.println("容器为空，暂停消费……");
                    list.wait();
                }

                Integer remove = list.remove(0);
                Thread.sleep(2000);
                System.out.println("消费一个对象" + remove);
                list.notifyAll();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                Producer.write();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                Producer.read();
            }
        }).start();



    }

}
