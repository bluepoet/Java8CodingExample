package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 20..
 */
public class B017 {
    public static void main(String[] args) {

    }
}

@FunctionalInterface
interface MyFunctionalInterface2 {
    public static final int constant = 1;

    public abstract void abstractInstanceMethod();

    public default void concreateInstanceMethod() {
        System.out.println("concreate default method");
    }

    public static void concreterStaticMethod() {
        System.out.println("static method");
    }
}