package dev.cisnux.virtualthread;

import lombok.Cleanup;

import java.time.Duration;
import java.util.concurrent.Executors;

public class ExecutorVirtualThreadApp {
    public static void main(String[] args) {
        @Cleanup final var executorService = Executors.newVirtualThreadPerTaskExecutor();
        for (var i = 0; i < 10_000; i++) {
            // default value of daemon is true
            // can't change the daemon
            final var counter = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(Duration.ofSeconds(2));
                    System.out.println("Hello " + counter + ' ' + Thread.currentThread() + "!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }
}
