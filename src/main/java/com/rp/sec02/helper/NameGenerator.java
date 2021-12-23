package com.rp.sec02.helper;

import com.rp.sourseutil.Util;
import reactor.core.publisher.Flux;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    // 1
    public static List<String> getNamesWithList(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    //2
    public static Flux<String> getNamesWithFlux(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName() {
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
