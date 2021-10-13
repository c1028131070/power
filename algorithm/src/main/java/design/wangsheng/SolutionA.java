package design.wangsheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

// 1. 有二十个账户。每个账户初始余额10000元。
// 2. 有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数。
// 3. 每个线程执行100次转账操作。
// 4. 最后请打印出二十个账户的余额
public class SolutionA {
    public static class Account{
        final int id;
        AtomicInteger amount = new AtomicInteger(10000);

        public Account(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", amount=" + amount +
                    '}';
        }
    }

    //转账方法
    public static boolean transfer(int amount, Account f, Account t) {

        if (f.amount.addAndGet(-amount) < 0) {
            System.out.println("账号" + f.id + "余额不足转账失败");
            //回滚
            f.amount.addAndGet(amount);
            return false;
        } else {
            //扣减成功 转入账号加钱
            t.amount.addAndGet(amount);
            return true;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        //创建20个账号
        Account[] accounts = new Account[20];
        for (int i = 0; i < 20; i++) {
            Account account = new Account(i);
            accounts[i] = account;
        }

        CountDownLatch countDownLatch = new CountDownLatch(10);
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                //随机金额
                int amount = ThreadLocalRandom.current().nextInt(100)+1;
                //随机账号
                int aif = ThreadLocalRandom.current().nextInt(20);
                int ait = ThreadLocalRandom.current().nextInt(20);
                while (aif==ait){
                    ait = ThreadLocalRandom.current().nextInt(20);
                }
                //转账
                transfer(amount,accounts[aif],accounts[ait]);
            }
            countDownLatch.countDown();
        };


        //启动
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        countDownLatch.await();

        //余额打印
        for (int i = 0; i < 20; i++) {
            System.out.println(accounts[i]);
        }

    }
}