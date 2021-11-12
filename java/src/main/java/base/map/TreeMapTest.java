package base.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<>(String::compareTo);
        treeMap.put("1",1);
        treeMap.put("5",5);
        treeMap.put("3",3);
        treeMap.put("0",0);
        treeMap.put("2",2);
        treeMap.put("21",2);
        System.out.println(treeMap);
    }
}
