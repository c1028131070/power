/*
package design.wangsheng;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SolutionB {

    //保存交易日信息
    public static Set<String> workingDay =new HashSet<>();
    static {
        workingDay.add("20211011");
        workingDay.add("20211012");
        workingDay.add("20211013");
        workingDay.add("20211014");
        workingDay.add("20211015");
        workingDay.add("20211018");
        workingDay.add("20211019");
        workingDay.add("20211020");
    }


    */
/**
     * 获取购买到确认间隔
     * @param buyTime
     * @return
     *//*

    public static long calInterval(Date buyTime){

        Date t1;
        if (DateUtil.hour(buyTime,true)<15){
            t1 = nextWorkingTime(buyTime);
        } else {
            Date t = nextWorkingTime(buyTime);
            t1 = nextWorkingTime(t);
        }

        return DateUtil.between(buyTime,t1, DateUnit.DAY,true);

    }

    */
/**
     *    获取下一个交易日
     *//*

    public static DateTime nextWorkingTime(Date date){
        //i<20 20天内肯定能找到下一交易日
        for (int j = 1; j < 20; j++) {
            DateTime nextDay = DateUtil.offsetDay(date, j);
            String dayStr = DateUtil.format(nextDay, "yyyyMMdd");
            if (workingDay.contains(dayStr)){
                return nextDay;
            }
        }
        throw new RuntimeException("交易日信息错误，未找到下一个交易日");
    }

    public static void main(String[] args) {

        System.out.println(new SolutionB().calInterval(DateUtil.parse("2021-10-12 14:00")));

    }
}
*/
