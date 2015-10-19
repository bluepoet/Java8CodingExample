package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B004 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello Lambda4!!!");
        r.run();
    }
}
