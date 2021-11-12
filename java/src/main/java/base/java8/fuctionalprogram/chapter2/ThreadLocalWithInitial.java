package base.java8.fuctionalprogram.chapter2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalWithInitial {

    private static ThreadLocal<DateFormat> threadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) {
        Date date1 = new Date(1614820308016L);
        Date date2 = new Date(1615820309016L);
        /** 输出
         * 初始定义时间1： 2021-03-04 09:11:48
         * 初始定义时间2： 2021-03-15 22:58:29
         */
        System.out.println("初始定义时间1： " + threadLocal.get().format(date1));
        System.out.println("初始定义时间2： " + threadLocal.get().format(date2));
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i<100) {
                String dateString = threadLocal.get().format(date1);
                if (!dateString.equals("2021-03-04 09:11:48")) {
                    System.out.println(Thread.currentThread().getName() + "异常时间： " + dateString);
                }
                i++;
            }
        },"线程1");

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i<100) {
                String dateString = threadLocal.get().format(date2);
                if (!dateString.equals("2021-03-15 22:58:29")) {
                    System.out.println(Thread.currentThread().getName() + "异常时间： " + dateString);
                }
                i++;
            }
        },"线程2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
