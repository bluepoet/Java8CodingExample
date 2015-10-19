package net.bluepoet.chap06;

import java.math.BigDecimal;

/**
 * Created by Mac on 2015. 9. 29..
 */
public class MyFunctionInterfaceExample {

    public static void main(String[] args) {
        println(1L, "bluepoet", "test@daum.net", (id, name, email) -> "id = " + id + ", name = " + name + ", email = " + email);

        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));

//        final InvalidFunctionalInterface anonymousClass = new InvalidFunctionalInterface() {
//            @Override
//            public <T> String mkString(T value) {
//                http://zeroturnaround.com/rebellabs/getting-started-with-intellij-idea-as-an-eclipse-user/4/return value.toString();
//            }
//        };
//
//        System.out.println(anonymousClass.mkString(123));

//        final InvalidFunctionalInterface invalidFunctionalInterface = value -> value.toString();
//        System.out.println(invalidFunctionalInterface.mkString(123));
    }

    private static <T1, T2, T3> void println(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }

}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
}

//@FunctionalInterface
//interface InvalidFunctionalInterface {
//    <T> String mkString(T value);
//}