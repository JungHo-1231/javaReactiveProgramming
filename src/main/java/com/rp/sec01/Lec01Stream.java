package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1).map(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i * 2;
        });

//        System.out.println("stream = " + stream); // stream is lazy
        // You will not do anything unless you connect that terminal operator.
        stream.forEach(System.out::println);
        // data will go thought and reach this terminal operator.
    }
}
