package com.bytedance.mmsbdemo.common;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class DemoThread extends Thread {
    @Override
    public void run() {
        System.out.println("demo thread running..");
    }
}

class CallableImpl implements Callable<Integer> {
    public Integer call() throws Exception {
        System.out.println("CallableImpl.call() invoking.....");
        return new Integer(11);
    }
}

public class Grammer {
    public static void main(String[] args) {
        CallableImpl call = new CallableImpl();
        FutureTask<Integer> ft = new FutureTask<>(call);
        new Thread(ft, "Callable & Future Thread 1").start();
        try {
            Integer o = ft.get(); // 通过FutureTask对象获取到线程执行的返回值
            System.out.println(o);
        } catch (Exception e) {

        }

        new Thread(ft, "Callable & Future Thread 2").start();
    }

    private void test1() {
        Student stu = new Student(34, "ByteDance");
        if (stu == null) {

        }
        try {
            System.out.println(2 / 0);
        } catch (Exception e) {
        } finally {
            System.out.println("rechard.. doing.. now..");
        }
        System.out.println("UUUUUUUUUUUU");
        System.getProperty("sun.boot.class.path");
        System.getProperty("java.class.path");
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    //使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
