package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B002 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello lambda!!");
            }
        };

        r.run();
    }
}
