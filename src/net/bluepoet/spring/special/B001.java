package net.bluepoet.spring.special;

/**
 * Created by Mac on 2015. 10. 19..
 */
public class B001 {
    public static void main(String[] args) {
        MyTest mt = new MyTest();

        Runnable r = mt;

        r.run();
    }
}

class MyTest implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello Lambda!!");
    }
}


