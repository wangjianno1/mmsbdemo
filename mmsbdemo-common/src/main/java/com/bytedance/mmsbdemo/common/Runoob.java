package com.bytedance.mmsbdemo.common;

import java.util.LinkedList;
import java.util.List;

public class Runoob {
    private List linkedList;
    private byte[] lock = new byte[0];

    public Runoob() {
        this.linkedList = new LinkedList<String>();
    }

    // 删除共享池中的元素
    public String removeElement() throws InterruptedException {
        synchronized (lock) {
            // 列表为空就等待
            while (linkedList.isEmpty()) {
                System.out.println("List is empty...");
                lock.wait();
                System.out.println("Waiting...");
            }
            String element = (String) linkedList.remove(0);
            return element;
        }
    }

    // 向共享池中添加元素
    public void addElement(String element) {
        System.out.println("Opening...");
        synchronized (lock) {
            // 添加一个元素，并通知元素已存在
            linkedList.add(element);
            System.out.println("New Element:'" + element + "'");
            lock.notifyAll();
            System.out.println("notifyAll called!");
        }
        System.out.println("Closing...");
    }

    public static void main(String[] args) {
        final Runoob demo = new Runoob();

        Runnable runA = new Runnable() {
            public void run() {
                try {
                    String item = demo.removeElement();
                    System.out.println("" + item);
                } catch (InterruptedException ix) {
                    System.out.println("Interrupted Exception!");
                } catch (Exception x) {
                    System.out.println("Exception thrown.");
                }
            }
        };

        Runnable runB = new Runnable() {
            // 执行添加元素操作，并开始循环
            public void run() {
                demo.addElement("Hello!");
            }
        };

        try {
            Thread threadA1 = new Thread(runA, "Google");
            threadA1.start();
            Thread.sleep(500);

            Thread threadA2 = new Thread(runA, "Runoob");
            threadA2.start();
            Thread.sleep(500);

            Thread threadB = new Thread(runB, "Taobao");
            threadB.start();
            Thread.sleep(1000);

            threadA1.interrupt();
            threadA2.interrupt();
        } catch (InterruptedException x) {
        }
    }
}
