package interview;

public class ClassMemberTest {

    private static int i=100;

    public static void main(String[] args) {
        ClassMemberTest classMemberTest = new ClassMemberTest();
        classMemberTest.i++;
        ClassMemberTest.i--;
        System.out.println(ClassMemberTest.i);
    }
}
