package com.rp.sec02;

import com.rp.sourseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.rp.sourseutil.Util.*;

public class Lec09FluxFromMono {

    public static void main(String[] args) {
        // mono -> flux
/*
        Mono<String> mono = Mono.just("a");

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(Util.onNext());
*/

        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // change flux to mono, 오직 한 개의 값만 전달
                .subscribe(onNext(), onError(), onComplete());
    }


}
