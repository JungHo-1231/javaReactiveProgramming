package com.rp.sec02.assignment.mine;

import com.rp.sourseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class StockPriceService {

    public static void main(String[] args) {
        Flux<Integer> flux = Flux.range(1, 10)
                .map(i -> getStockPrice());

        flux.subscribe(Util.onNext());

    }


    public static int getStockPrice() {
        for (int i = 0; i < 10; i++) {
            Util.sleepSeconds(1);
            Random random = new Random();
            return random.nextInt(45);
        }
        return -1;
    }
}
