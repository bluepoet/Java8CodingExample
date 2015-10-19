package net.bluepoet.spring.special;

import java.util.Arrays;

/**
 * Created by Mac on 2015. 10. 20..
 */
public class B013 {
    public static void main(String[] args) {
        Integer[] ages = {20, 25, 18, 27, 30, 21, 17, 19, 34, 28};

        Arrays.stream(ages)
                .filter(age -> age < 20)
                .forEach(System.out::println);

//        Arrays.stream(ages).sorted().forEach(System.out::println);
    }
}
