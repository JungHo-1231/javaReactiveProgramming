package com.rp.sec02;

import com.rp.sourseutil.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {

//        Flux.range(1, 10).subscribe(Util.onNext());

        // 1
        Flux.range(1, 10)
                .subscribe(i -> System.out.println(Util.faker().name().fullName()));

        // 2
        Flux.range(1, 10)
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.onNext());

        // 3
        Flux.range(1, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
