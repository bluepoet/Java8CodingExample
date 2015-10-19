package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B005 {
    public static void main(String[] args) {
        MyFunctionalInterface mfi = a -> a * a;
        MyFunctionalInterface mfi1 = a -> (a / a) + a;

        int b = mfi.runSomething(5);
        int c = mfi1.runSomething(10);

        System.out.println(b);
        System.out.println(c);
    }
}

@FunctionalInterface
interface MyFunctionalInterface {
    public abstract int runSomething(int cout);
}
