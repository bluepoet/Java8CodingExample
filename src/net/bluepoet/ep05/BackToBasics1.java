package net.bluepoet.ep05;

/**
 * Created by Mac on 2015. 10. 3..
 */
public class BackToBasics1 {
    public static void main(String[] args) {
        final String obj1 = new String("a");
        final String obj2 = new String("a");

        if (obj1 == obj2) {
            System.out.println("1");
        }
        if (obj1.equals(obj2)) {
            System.out.println("2");
        }

        if(obj1 != null && !obj1.isEmpty()) {

        }
    }
}