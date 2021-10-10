package base.generictype;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {

    /**
     * 由于java泛型的是通过类型擦除实现的，所以本例中是无法通过编译的（jdk6可能可以）
     * 因为重载的条件时方法签名不同，而方法返回值不在签名里面。两个方法都是method(List list)
     */

/*        public static String method(List<String> list) {
            System.out.println("invoke method(List<String> list)");
            return "";
        }
        public static int method(List<Integer> list) {
            System.out.println("invoke method(List<Integer> list)");
            return 1;
        }
        public static void main(String[] args) {
            method(new ArrayList<String>());
            method(new ArrayList<Integer>());
        }*/
}
