package dev.cisnux.virtualthread;

import java.io.IOException;
import java.time.Duration;

public class VirtualThreadApp {
    public static void main(String[] args) throws IOException {
//        for (int i = 0; i < 1000; i++) {
            // out off memory error
        for (int i = 0; i < 10_000; i++) {
            // default value of daemon is true
            // can't change the daemon
            final var thread = Thread.ofVirtual().name("fajra-" + i).unstarted(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            thread.start();
//            thread.join();
        }
        System.in.read();
    }
}
