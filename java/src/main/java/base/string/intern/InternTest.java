package base.string.intern;

public class InternTest {


    public static void main(String[] args) {

        /**
         *  在jdk1.6及以前，常量池存在方法区，执行string.intern()方法会把首次遇到的字符串实例复制到常量池中
         *  在jdk1.7及以后，常量池移到了堆中，执行string.intern()方法就不需要拷贝了（因为本身就在堆区），只需在第一次遇到的时候记录一次实例的引用即可
         */

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String a = new String("haha");
        System.out.println(a.intern() == a);//false
    }
}
