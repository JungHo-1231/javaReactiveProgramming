package com.rp.sec01;

import com.rp.sourseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.swing.*;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {

        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        getName();

        Util.sleepSeconds(4);
    }


    // this act like publisher
    private static Mono<String> getName() {
        System.out.println("entered  getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
