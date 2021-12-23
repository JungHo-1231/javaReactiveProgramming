package com.rp.sec02;

import com.github.javafaker.Faker;
import com.rp.sourseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {

        // 1
        // Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        // 2
        // Flux<Object> flux = Flux.empty();

        // 3
        //Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", Util.faker().name().fullName());

/*      // 4
        flux.subscribe(
                util.onnext(),
                util.onerror(),
                util.oncomplete()
        );
*/

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 == 0);

        integerFlux
                .subscribe(i -> System.out.println("Sub 1 : " + i));

        evenFlux
                .subscribe(i -> System.out.println("Sub 2 : " + i));
    }
}

