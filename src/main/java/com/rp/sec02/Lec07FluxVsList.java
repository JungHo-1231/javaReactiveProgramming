package com.rp.sec02;

import com.rp.sec02.helper.NameGenerator;
import com.rp.sourseutil.Util;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        List<String> names = NameGenerator.getNamesWithList(5);
        System.out.println("names = " + names);


        Flux<String> namesWithFlux = NameGenerator.getNamesWithFlux(5);
        namesWithFlux.subscribe(Util.onNext());
    }
}
