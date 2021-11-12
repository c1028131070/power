package base.map;

import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetTest {

    static class User {

        private Integer uid;

        public User(Integer uid) {
            this.uid = uid;
        }

        /**
         * 注意大对象排除
         */
        @Override
        public String toString() {
            return String.valueOf(uid);
        }
    }

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet((Comparator<User>) (o1, o2) -> o1.uid - o2.uid);
        treeSet.add(new User(2));
        treeSet.add(new User(5));
        treeSet.add(new User(8));
        treeSet.add(new User(1));
        treeSet.add(new User(0));
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet.pollLast());
    }
}
