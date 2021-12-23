package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                .map((i) -> {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });

        // 스레드 슬랩이 작동하지 않는다 왜냐하면 steam 은 lazy 이기 때문이다.
        //  System.out.println(stream);

        stream.forEach(System.out::println);
    }
}
