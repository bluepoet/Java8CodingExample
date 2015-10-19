package net.bluepoet.spring.special;

import java.util.function.Supplier;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B010 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello");
        Supplier<Integer> sup = () -> 3 * 3;
    }
}
