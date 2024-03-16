package dev.cisnux.virtualthread;

import java.time.Duration;

public class PlatformThreadApp {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            // out off memory error
//        for (int i = 0; i < 10_000; i++) {
            // default value of daemon is false
            final var thread = Thread.ofPlatform().name("fajra-" + i).daemon(false).unstarted(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
        }
    }
}
