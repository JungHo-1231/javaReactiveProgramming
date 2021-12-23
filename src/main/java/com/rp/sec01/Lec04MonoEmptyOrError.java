package com.rp.sec01;

import com.rp.sourseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(1).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

    // 퍼블리셔 역활을 한다.
    private static Mono<String> userRepository(int userId) {

        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            //return null;
            return Mono.empty();
        } else
            return Mono.error(new RuntimeException("Not in the allowed range"));

    }
}
