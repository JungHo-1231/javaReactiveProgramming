package com.rp.sec01;

import com.rp.sourseutil.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        // 1
        mono.subscribe();

        // 2
//        mono.subscribe(
//                item -> System.out.println(item),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("complete")
//        );

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
