package base.bigdecimal;

import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void test1() {
        BigDecimal bigDecimal1 = new BigDecimal(1.0);
        BigDecimal bigDecimal2 = new BigDecimal(1.00);
        System.out.println(bigDecimal1.equals(bigDecimal2));

        BigDecimal bigDecimal3 = new BigDecimal("1.2");
        BigDecimal bigDecimal4 = new BigDecimal("1.20");
        System.out.println(bigDecimal3.equals(bigDecimal4));

    }
}
