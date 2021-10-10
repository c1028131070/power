package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// 1. 有二十个账户。每个账户初始余额10000元。
// 2. 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
// 3. 每个线程执行100次转账操作。
// 4. 最后请打印出二十个账户的余额
// 5. 尽量考虑吞吐量
public class TransferAccount {

    private static final int ACCOUNT_NUM = 20;

    private static List<Account> accountList;

    private static AtomicInteger curTime = new AtomicInteger(0);

    static class Account {
        // 唯一id
        private int accId;
        private double balance;

        public Account(int accId, double balance) {
            this.accId = accId;
            this.balance = balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 初始化账户
        accountList = new ArrayList<>();
        for (int i = 1; i <= ACCOUNT_NUM; i++) {
            accountList.add(new Account(i, 10000.0));
        }

        List<Thread> threadList = null;
        for (int i = 0; i < 10; i++) {
            threadList = new ArrayList<>();
            threadList.add(new Thread(runnable));
        }

        // 启动线程
        for (Thread thread : threadList) {
            thread.start();
            thread.join();
        }

        double totalBalance = 0;
        for (Account account : accountList) {
            System.out.println(account.accId + "   " + account.balance);
            totalBalance += account.balance;
        }
        System.out.println("总金额:" + totalBalance);
    }

    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            // 取出两个随机账户
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int outIndex = random.nextInt(ACCOUNT_NUM);
                int inIndex = random.nextInt(ACCOUNT_NUM);
                while (outIndex == inIndex) {
                    inIndex = random.nextInt(ACCOUNT_NUM);
                }
                int balance = random.nextInt(100);
                transfer(accountList.get(outIndex), accountList.get(inIndex), balance);
            }
        }
    };

    public static void transfer(Account out, Account in, double balance) {
        System.out.println(curTime.incrementAndGet() + " " + out.accId + "给" + in.accId + "转账" + balance);
        // 单进程中可采用jvm锁，否则采用分布式锁，考虑死锁问题
        Account smallIdAcc = out.accId > in.accId ? in : out;
        Account bigIdAcc = out.accId > in.accId ? out : in;
        synchronized (smallIdAcc) {
            synchronized (bigIdAcc) {
                if (out.balance > balance) {
                    out.balance -= balance;
                    in.balance += balance;
                }
            }
        }


    }

}
