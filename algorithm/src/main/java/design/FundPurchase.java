package design;

/**
 * // 评测题目B: 用程序实现实际中的基金申购日与确认日之间的日期间隔计算，要考虑节假日包含春节、国庆。
 * // 例如：
 * // 1、周四15:00前购买基金，那么T日为周四，T+1日为周五，从购买到确认中间间隔1天；
 * // 2、周四15:00后购买基金，那么T日为周五，T+1日为下周一，从购买到确认中间间隔4天；
 * // 3、周五15:00前购买基金，那么T日为周五，T+1日为下周一，从购买到确认中间间隔3天；
 * // 4、周五15:00后购买基金，那么T日为下周一，T+1日为下周二，从购买到确认中间间隔4天。
 */
public class FundPurchase {
    /**
     * 伪代码
     * if（买入时间<15:00） return getAfterTradingDay(2); // 获取后续第二个交易日
     * if（买入时间>15:00） return getAfterTradingDay(1); // 获取后续第一个交易日
     *
     * getAfterTradingDay(int offset) {
     *     date today = getToday();
     *     date nextDay = today;
     *     while(offset>0) {
     *          nextDay = getAfterOneDay(nextDay);
     *         if(isTradingDay(nextDay)){
     *             offset--;
     *         };
     *     }
     *     return nextDay;
     * }
     */

}


