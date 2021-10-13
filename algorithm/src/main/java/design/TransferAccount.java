package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// 评测题目2:
// 1. 有二十个账户。每个账户初始余额10000元。
// 2. 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
// 3. 每个线程执行100次转账操作。
// 4. 最后请打印出二十个账户的余额

//  注意：
//  1. 用面向对象封装的方式（非数据库方式），模拟账户余额。如 class Account { private int balance = 1000000}

/**
 * 思路：
 * 创建线程，执行转账。
 * 注意点：随机数、转账的线程安全与性能
 */
public class TransferAccount {

    private static final int ACCOUNT_NUM = 20;

    // 账户集合
    private static List<Account> accountList;

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(5000));

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    // 统计用
    private static AtomicInteger curTime = new AtomicInteger(0);

    static class Account {
        // 唯一id
        private int accId;
        private int balance;

        public Account(int accId, int balance) {
            this.accId = accId;
            this.balance = balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 初始化账户
        accountList = new ArrayList<>();
        for (int i = 1; i <= ACCOUNT_NUM; i++) {
            accountList.add(new Account(i, 1000000));
        }

        for (int i = 0; i < 10; i++) {
            // 这里没有保证每个线程执行100次，感觉没关系，如果需要就单独创建线程的方式
            threadPoolExecutor.execute(runnable);
        }
        // 阻塞
        countDownLatch.await();

        int totalBalance = 0;
        for (Account account : accountList) {
            System.out.println(account.accId + "   " + account.balance * 1.0 / 100);
            totalBalance += account.balance;
        }
        System.out.println("总金额:" + totalBalance * 1.0 / 100);
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
                int balance = random.nextInt(10000);
                transfer(accountList.get(outIndex), accountList.get(inIndex), balance);
            }
            countDownLatch.countDown();
        }
    };

    public static void transfer(Account out, Account in, int balance) {
        System.out.println(curTime.incrementAndGet() + " " + out.accId + "给" + in.accId + "转账" + balance * 1.0 / 100);
        // 单进程中可采用jvm锁，否则采用分布式锁，考虑死锁问题
        Account smallIdAcc = out.accId > in.accId ? in : out;
        Account bigIdAcc = out.accId > in.accId ? out : in;

        if (out.balance < balance) {
            System.out.println("余额不足");
            return;
        }
        synchronized (smallIdAcc) {
            synchronized (bigIdAcc) {
                if (out.balance > balance) {
                    out.balance -= balance;
                    in.balance += balance;
                } else {
                    System.out.println("余额不足");
                }
            }
        }
    }
}
