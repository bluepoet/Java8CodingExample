package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B007 {
    public static void main(String[] args) {
        doIt(a -> a * a);
    }

    private static void doIt(MyFunctionalInterface mfi) {
        int b = mfi.runSomething(6);

        System.out.println(b);
    }
}
