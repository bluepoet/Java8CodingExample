package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B009 {
    public static void main(String[] args) {
        MyFunctionalInterface mfi = todo();

        int result = mfi.runSomething(3);

        System.out.println(result);
    }

    private static MyFunctionalInterface todo() {
        return num -> num * num;
    }
}
