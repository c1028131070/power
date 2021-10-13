package interview;

public class MethodPram {

    public static void main(String[] args) {
        int i = 0;
        char[] arr = new char[]{'a', 'b', 'c'};
        change(i, arr);
        System.out.println(i + " " + arr[0] + arr[1] + arr[2]);
    }

    private static void change(int i, char[] arr) {
        i = 10;
        arr[0] = 'g';
    }

}
