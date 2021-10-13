package interview;

public class IntegerCache {

    public static void main(String[] args) {
        Integer a = 80;
        Integer b = 80;
        Integer c = new Integer(80);
        System.out.println(a==b);
        System.out.println(b==c);
    }
}
