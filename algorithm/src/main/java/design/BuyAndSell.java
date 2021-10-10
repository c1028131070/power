package design;

// 有两个List， A 和 B。 A代表的是买入列表（买入份数、单价，时间），B代表的是卖出列表（卖出份数，单价，时间）
// 计算：剩余的总份数以及剩余部分的买入总金额。

// 一个例子
// 买入list :
// 第一次： <1000, 1.5, 2021-01-01>
// 第二次： <1000, 2.1, 2021-01-05>
// 第三次： <1000, 1.7, 2021-01-07>
// 第四次： <1000, 1.1, 2021-01-09>

// 卖出list :
// 第一次： <2500, 2.2, 2021-01-08>

// 则结果为：
// <1500, 1950>

// 要求：先买的会被先卖; 每一次买或卖，所有份数的单价都是相同的

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class BuyAndSell {
    private static class Trade {
        Integer num;
        Double price;
        Date date;

        Trade(Integer num, Double price, Date date) {
            this.date = date;
            this.num = num;
            this.price = price;
        }
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Trade> buyList = new ArrayList<>();
        List<Trade> sellerList = new ArrayList<>();
        buyList.add(new Trade(1000, 1.5d, sdf.parse("2021-01-01")));
        buyList.add(new Trade(1000, 2.1d, sdf.parse("2021-01-05")));
        buyList.add(new Trade(1000, 1.7d, sdf.parse("2021-01-07")));
        buyList.add(new Trade(1000, 1.1d, sdf.parse("2021-01-09")));
        sellerList.add(new Trade(2500, 2.2d, sdf.parse("2021-01-08")));
        //题目未说明两个list是否已经按照日期升序排列好了, 如果未排好序可以放开注释代码先排序
        buyList.sort(Comparator.comparing(o -> o.date));

        int buyNum = 0;
        for (Trade buyTrade : buyList) {
            buyNum += buyTrade.num;
        }
        int sellNum = 0;
        for (Trade sellTrade : sellerList) {
            sellNum += sellTrade.num;
        }
        int remainNum = buyNum - sellNum;
        double remainPrice = 0.0;
        int remainNumTemp = remainNum;
        for (int i = buyList.size() - 1; i >= 0; i--) {
            Trade buyTrade = buyList.get(i);
            // 留下的份数比一次买入的多，则追溯上一次买入
            if (buyTrade.num < remainNumTemp) {
                remainPrice += buyTrade.num * buyTrade.price;
                remainNumTemp -= buyTrade.num;
            } else {
                // 否则只计算本次买入
                remainPrice += remainNumTemp * buyTrade.price;
                break;
            }
        }

        System.out.println(remainNum);
        System.out.println(remainPrice);
    }
}
