package base.java8.fuctionalprogram.chapter3;

import org.apache.commons.collections4.CollectionUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Question6And7 {

    /***
     * 6. 计算一个字符串中小写字母的个数（提示：参阅 String 对象的 chars 方法）。
     * @param str
     * @return
     */
    public int smallLetterNum(String str) {
        return (int) str.chars().filter(c -> c >= 97 && c <= 122).count();
    }

    public int smallLetterNumAns(String str) {
        return (int) str.chars().filter(Character::isLowerCase).count();
    }

    /**
     * 7. 在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回 Optional
     * <String> 对象。
     */
    public Optional<String> mostSmallLetterNumString(List<String> stringList) {
/*        if (CollectionUtils.isEmpty(stringList)) {
            return Optional.empty();
        }*/
        return stringList.stream().max(Comparator.comparingInt(this::smallLetterNum));
    }


    @Test
    public void test() {
        System.out.println(smallLetterNum("aBjfkBmJIS"));
        System.out.println(smallLetterNumAns("aBjfkBmJIS"));
        System.out.println(mostSmallLetterNumString(Arrays.asList("aBjfkBmJIS","fdshjkuHaB","FBHDFDaJFeDK",
                "DGSUFHGDHFGHGD","hfjdhfhsfsdf")).orElse("abc"));
    }

}
