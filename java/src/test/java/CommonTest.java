import org.junit.Test;

public class CommonTest {

    @Test
    public void test1() {
        Integer num=0;
        add(num);
        System.out.println(num);
    }

    public void add(Integer num) {
        num++;
    }

    @Test
    public void test2() {
        int i=0;
        sout(i+1);
    }

    public void sout(Integer num) {
        System.out.println(num);
    }
}
