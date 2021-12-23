package com.rp.sec02;

import com.rp.sourseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onCompleted");
                    }
                });

        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4);
        Util.sleepSeconds(3);
    }
}
