package net.bluepoet.spring.special;

import java.util.function.Supplier;

/**
 * Created by Mac on 2015. 10. 20..
 */
public class B016 {
    public static void main(String[] args) {
        Supplier<B016> factory = B016::new;

        B016 b016_3 = factory.get();
        B016 b016_4 = factory.get();

        System.out.println(b016_3.hashCode());
        System.out.println(b016_4.hashCode());
    }
}
