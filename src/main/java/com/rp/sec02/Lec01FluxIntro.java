package com.rp.sec02;

import com.github.javafaker.Faker;
import com.rp.sourseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {

//        Flux<Integer> flux = Flux.just(1,2,3,4);

        Flux<Object> flux = Flux.just(
                1,
                2,
                3,
                4,
                "a",
                Util.faker().name().firstName()
        );

        flux.subscribe(
                Util.onNext()
                , Util.onError()
                , Util.onComplete()
        );

    }
}

