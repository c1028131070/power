package interview;

import java.text.ParseException;

public class ExceptionRange {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("run");
                int i = 1/0;
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("End");
    }



}
