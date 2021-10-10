package base.box;

public class BoxUnbox {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); // true  Integer cache
        System.out.println(e == f); // false default Integer cache is -127~128
        System.out.println(c == (a + b)); // true 做运算拆箱，向基础类型转型
        System.out.println(c.equals(a + b)); // true 装箱
        System.out.println(g == (a + b));  // true int会向long转型 i2l
        System.out.println(g.equals(a + b)); // false 类型都不一致
    }
}
